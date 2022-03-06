package main;

import java.util.*;

/*
    752. Open the Lock

    You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
    The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
    Each move consists of turning one wheel one slot.

    The lock initially starts at '0000', a string representing the state of the 4 wheels.

    You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
    the wheels of the lock will stop turning and you will be unable to open it.

    Given a target representing the value of the wheels that will unlock the lock,
    return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 */
public class OpenTheLock {
    public static void main (String[] args) {
        OpenTheLock o = new OpenTheLock();
        int ans = o.openLock(new String[]{
                "8888"
        }, "0009");
        System.out.println(ans);
    }

    private static final int DIGITS = 4;

    public int openLock(String[] deadends, String target) {
        if (target == null || target.length() == 0) {
            return -1;
        }

        // want to return minimum total number of turns -> BFS
        // want to chack layer by layer
        HashSet<String> set = new HashSet();
        for (String s : deadends) {
            set.add(s);
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i < size ; i++) {
                String currString = queue.poll();

                if (set.contains(currString)) {
                    continue;
                } else {
                    set.add(currString);
                }

                if (currString.equals(target)) {
                    return level;
                }

                // Generate next possible string combination
                Set<String> nextCombination = generateString(currString);

                for (String s : nextCombination) {
                    if (!set.contains(s)) {
                        queue.offer(s);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    private Set<String> generateString(String startingString) {
        HashSet<String> set = new HashSet<>();
        char[] stringArr = startingString.toCharArray();
        for (int i = 0 ; i < DIGITS ; i++) {

            char currChar = stringArr[i];
            // increment
            stringArr[i] = currChar == '9' ? '0' : (char) (currChar + 1);
            set.add(new String(stringArr));

            // decrement
            stringArr[i] = currChar == '0' ? '9' : (char) (currChar - 1);
            set.add(new String(stringArr));

            stringArr[i] = currChar;
        }

        return set;
    }
}
