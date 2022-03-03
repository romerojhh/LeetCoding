package main;

import java.util.HashMap;
import java.util.Map;

/*  567. Permutation in String

    Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

    In other words, return true if one of s1's permutations is the substring of s2.


    1)  How do we know string p is a permutation of string s? Easy, each character in p is in s too.
        So we can abstract all permutation strings of s to a map (Character -> Count).
        i.e. abba -> {a:2, b:2}. Since there are only 26 lower case letters in this problem, we can just use an array to represent the map.

    2)  How do we know string s2 contains a permutation of s1?
        We just need to create a sliding window with length of s1, move from beginning to the end of s2.
        When a character moves in from right of the window, we subtract 1 to that character count from the map.
        When a character moves out from left of the window, we add 1 to that character count.
        So once we see all zeros in the map, meaning equal numbers of every characters between s1 and the substring in the sliding window,
        we know the answer is true.

 */
public class PermutationInString {
    public static void main (String[] args) {
        PermutationInString p = new PermutationInString();
        System.out.println(p.checkInclusion("ab", "cd"));
        System.out.println(p.checkInclusion("ab", "eidbaooo"));
        System.out.println(p.checkInclusion("abcd", "zxbacxzbcxbdca"));
        System.out.println(p.checkInclusion("adc", "dcda"));
        System.out.println(p.checkInclusion("baac", "ac"));
    }

    public boolean checkInclusion(String s1, String s2) {
        String shortest = null;
        String longest = null;


        if (s1.length() <= s2.length()) {
            shortest = s1;
            longest = s2;
        } else {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // initialize map
        for (Character c : shortest.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int windowLength = shortest.length();
        boolean allZero = false;

        for (int i = 0, j = 0 ; i < longest.length() && !allZero ; i++) {
            char currChar = longest.charAt(i);

            if (map.containsKey(currChar)) {

                if (i - j < windowLength) {
                    map.put(currChar, map.get(currChar) - 1);
                } else {
                    char backChar = longest.charAt(i);
                    char frontChar = longest.charAt(j);
                    if (map.containsKey(backChar)) {
                        map.put(backChar, map.get(backChar) - 1);
                    }
                    if (map.containsKey(frontChar)) {
                        map.put(frontChar, map.get(frontChar) + 1);
                    }
                    j++;
                }

                allZero = checkZero(map);
            } else {
                resetMap(map, shortest);
                j = i;
            }

        }

        return allZero;
    }

    private void resetMap(HashMap<Character,Integer> map, String s) {
        map.clear();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
    }

    private boolean checkZero(HashMap<Character, Integer> map) {
        int numZeroes = 0;
        for (Map.Entry<Character, Integer> i : map.entrySet()) {
            if (i.getValue() == 0) {
                numZeroes++;
            }
        }

        return numZeroes == map.size();
    }

    /*
                    if (map.containsKey(longest.charAt(j))) {
                    map.put(longest.charAt(j), map.get(longest.charAt(j)) + 1);
                } else {
                    map.put(longest.charAt(j), 1);
                }

    public boolean checkInclusion(String s1, String s2) {
        boolean isAvailable = false;
        String shortest = null;
        String longest = null;

        if (s1.length() <= s2.length()) {
            shortest = s1;
            longest = s2;
        } else {
            shortest = s2;
            longest = s1;
        }

        HashSet<Character> set = new HashSet<>();
        HashSet<Character> trashSet = new HashSet<>();

        resetSet(set, shortest);

        int i = 0;
        while (!isAvailable && i < longest.length()) {
            char currChar = longest.charAt(i);

            if (set.contains(currChar) || trashSet.contains(currChar)) {
                set.remove(currChar);
                trashSet.add(currChar);
            } else {
                // if the removing process is started before, but not fully remove the thing in the set,
                // we will reset the state of the set
                if (set.size() != shortest.length() && set.size() != 0) {
                    resetSet(set, shortest);
                    trashSet.clear();
                }
            }

            if (set.size() == 0) {
                isAvailable = true;
            }

            i++;
        }

        return isAvailable;
    }

    private void resetSet(HashSet<Character> set, String s) {
        for (Character c : s.toCharArray()) {
            set.add(c);
        }
    }

     */
}
