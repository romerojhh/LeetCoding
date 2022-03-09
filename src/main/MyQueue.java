package main;

import java.util.Stack;

public class MyQueue {
    public static void main (String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
    Stack<Integer> s1;
    Stack<Integer> s2;
    int size;
    boolean isExecutedPush;
    boolean isExecutedPop;

    public MyQueue() {
        this.size = 0;
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
        this.isExecutedPush = true;
        this.isExecutedPop = true;
    }

    public void push(int x) {
        // If pop is executed before, we have to update the current content in s1
        if (isExecutedPop) {
            s1.clear();
            for (int i : s2) {
                s1.push(i);
            }
            isExecutedPop = false;
        }

        isExecutedPush = true;

        s1.push(x);
        size++;
    }

    public int pop() {
        if (empty()) {
            throw new IllegalStateException();
        }
        // if push is executed before, we have to reset the s2
        if (isExecutedPush) {
            s2.clear();
        }

        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        // now s1 is empty

        /*
        if (isExecutedPush) {
            s2.clear();
            for (int i : s1) {
                s2.push(i);
            }
            isExecutedPush = false;
        }

        isExecutedPop = true;

         */
        size--;

        return s2.pop();
    }

    public int peek() {
        if (empty()) {
            throw new IllegalStateException();
        }

        if (isExecutedPush) {
            s2.clear();
            for (int i : s1) {
                s2.push(i);
            }
            isExecutedPush = false;
        }

        return s2.peek();
    }

    public boolean empty() {
        return size == 0;
    }
}
