package main;

import java.util.Stack;

/*
    150. Evaluate Reverse Polish Notation

    Evaluate the value of an arithmetic expression in Reverse Polish Notation.

    Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

    Note that division between two integers should truncate toward zero.

    It is guaranteed that the given RPN expression is always valid.
    That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
        String[] ops = new String[]{"4","13","5","/","+"};
        System.out.println(e.evalRPN(ops));
    }

    // ["2","1","+","3","*"]
    // 2 -> 1 -> +
    // res = 2 + 1
    // res -> 3 -> *
    // res = res * 3

    // ["4","13","5","/","+"]
    // 4 -> 13 -> 5 -> /
    // res = 13 / 5
    // 4 -> res -> +
    // res = 4 + res
    // return stack.pop

    // everytime we see a non-numerical character, we are going to pop and do arithmetic operation.
    // Store the result of that into a variable for the next operation

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String num : tokens) {
            try {
                stack.push(Integer.parseInt(num));
            } catch (NumberFormatException e) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (num.equals("*")) {
                    stack.push(num2 * num1);
                } else if (num.equals("+")) {
                    stack.push(num2 + num1);
                } else if (num.equals("/")) {
                    stack.push(num2/num1);
                } else if (num.equals("-")) {
                    stack.push(num2 - num1);
                }
            }
        }

        return stack.pop();
    }
}
