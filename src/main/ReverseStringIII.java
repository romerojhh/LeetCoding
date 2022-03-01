package main;

import java.util.Scanner;
import java.util.Stack;

/*
    557. Reverse Words in a String III

    Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 */

public class ReverseStringIII {
    public static void main(String[] args) {
        ReverseStringIII r = new ReverseStringIII();
        System.out.println(r.reverseWords("Hello, World!"));
    }

    public String reverseWords(String s) {
        Scanner sc = new Scanner(s);
        sc.useDelimiter(" ");
        Stack stack = new Stack();
        String ret = "";
        String ret2 = "";
        //abc def -> fed cba -> cba fed
        while(sc.hasNext()) {
            stack.push(sc.next());
        }
        while(!stack.empty()) {
            ret += stack.pop() + " ";
        }
        for (int i = ret.length() - 2 ; i>=0;i--) {
            ret2 += ret.charAt(i);
        }
        return ret2;
    }
}
