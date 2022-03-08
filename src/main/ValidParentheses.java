package main;

import java.util.Stack;

/*
    20. Valid Parentheses

    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

 */
public class ValidParentheses {
    public static void main (String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("()()"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for (int i = 0 ; i < charArr.length ; i++) {
            char curr = charArr[i];
            if (curr == '(')        stack.add(')');
            else if (curr == '{')   stack.add('}');
            else if (curr == '[')   stack.add(']');
            else if (stack.isEmpty()) return false;
            else if (curr != stack.peek()) return false;
            else stack.pop();
        }

        return stack.size() == 0;
    }
}
