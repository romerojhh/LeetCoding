package main;

import java.util.HashSet;

/* 1525. Number of Good Ways to Split a String
You are given a string s.

A split is called good if you can split s into two non-empty strings sleft and sright where their concatenation is equal to
s (i.e., sleft + sright = s) and the number of distinct letters in sleft and sright is the same.

Return the number of good splits you can make in s.
 */
public class NumberGoodWaysSplitString {
    public static void main(String[] args) {
        NumberGoodWaysSplitString n = new NumberGoodWaysSplitString();
        System.out.println(n.numSplits("aacaba"));
        System.out.println(n.numSplits("abcd"));
        System.out.println(n.numSplits("aaaa"));
        System.out.println(n.numSplits("aacc"));
        System.out.println(n.numSplits(""));
    }

    public int numSplits(String s) {
        // preprocess using prefix
        // aacaba
        // rightDir = 112233 -> the number of unique character seen so far
        // leftDir =  333221
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int total = 0;
        int stringLen = s.length();
        HashSet<Character> set = new HashSet<>();

        // need to store 'seen' unique character

        // create right dir
        int[] rightDir = new int[stringLen];
        rightDir[0] = 1;
        // add the first character seen
        set.add(s.charAt(0));
        for (int i = 1; i < stringLen; i++) {
            if (!set.contains(s.charAt(i))) {
                rightDir[i] = rightDir[i - 1] + 1;
                set.add(s.charAt(i));
            } else {
                rightDir[i] = rightDir[i - 1];
            }
        }

        // create left dir
        int[] leftDir = new int[stringLen];
        leftDir[stringLen - 1] = 1;
        set.remove(s.charAt(stringLen - 1));
        for (int i = stringLen - 2; i >= 0; i--) {
            if (set.contains(s.charAt(i))) {
                leftDir[i] = leftDir[i + 1] + 1;
                set.remove(s.charAt(i));
            } else {
                leftDir[i] = leftDir[i + 1];
            }
        }

        for (int i = 0; i < stringLen - 1; i++) {
            if (rightDir[i] == leftDir[i+1]) {
                total++;
            }
        }

        return total;
    }

}
