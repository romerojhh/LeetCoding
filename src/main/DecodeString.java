package main;

import java.util.Stack;

/*
    394. Decode String

    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
    Note that k is guaranteed to be a positive integer.

    You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.

    Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
    For example, there will not be input like 3a or 2[4].

 */
public class DecodeString {
    public static void main (String[] args) {
        DecodeString d = new DecodeString();
        System.out.println(d.decodeString("3[a]2[bc]"));
        System.out.println(d.decodeString("3[a2[c]]"));
        System.out.println(d.decodeString("2[abc]3[cd]ef"));
        System.out.println(d.decodeString("100[leetcode]"));
        System.out.println(d.decodeString("2[2[y]pq]ef"));
        System.out.println(d.decodeString("abc3[cd]xyz"));
    }

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (int i = 0 ; i < chars.length ; i++) {
            char currChar = chars[i];
            if (currChar == ']') {
                String currChars = stack.pop();
                stack.pop();
                int currRep = Integer.parseInt(stack.pop());

                if (stack.empty() || stack.peek().equals("[")) {
                    stack.push(buildString(currRep, currChars));
                } else {
                    stack.push(stack.pop() + buildString(currRep, currChars));
                }

            } else if (Character.isDigit(currChar)) {
                String temp = "";
                while (i < chars.length && Character.isDigit(currChar)) {
                    temp += currChar + "";
                    currChar = chars[++i];
                }
                stack.push(temp);
                i--;
            } else if (Character.isAlphabetic(currChar)) {
                String temp = "";
                while (i < chars.length && Character.isAlphabetic(currChar)) {
                    temp += currChar + "";
                    i++;
                    if (i < chars.length) {
                        currChar = chars[i];
                    }
                }


                if (!stack.empty() && !stack.peek().equals("[")) {
                    stack.push(stack.pop() + temp);
                } else {
                    stack.push(temp);
                }
                i--;
            } else {
                stack.push(currChar + "");
            }
        }

        return stack.pop();
    }

    private String buildString(int repNum, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < repNum; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
