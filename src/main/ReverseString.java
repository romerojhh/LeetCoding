package main;

/*
    344. Reverse String

    Write a function that reverses a string. The input string is given as an array of characters s.

    You must do this by modifying the input array in-place with O(1) extra memory.
 */

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString r = new ReverseString();
        char[] chars = new char[]{'a','b','c','d','e'};
        r.reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        for (int i = 0, j = s.length - 1 ; i <= j ; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
