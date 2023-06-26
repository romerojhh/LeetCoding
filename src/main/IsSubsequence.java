package main;

/* 392. Is Subsequence
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters
without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).

*/
public class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequence is = new IsSubsequence();
        System.out.println(is.isSubsequence("abc", "ahbgdc"));
        System.out.println(is.isSubsequence("axc", "ahbgdc"));
        System.out.println(is.isSubsequence("b", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.length() < s.length()) {
            return false;
        }
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (j < s.length() && t.charAt(i) == s.charAt(j)) {
                j++;
            }
        }

        return s.length() == j;
    }
}
