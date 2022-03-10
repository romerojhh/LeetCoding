package main;

import java.util.Stack;

/*
    232. Implement Queue using Stacks

    Implement a first in first out (FIFO) queue using only two stacks.
    The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 */
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
        s1.push(x);
        size++;
    }

    public int pop() {
        if (s2.empty()) {
            while (!s1.isEmpty()) {
                s2.add(s1.pop());
            }
        }

        size--;
        return s2.pop();
    }

    public int peek() {
        if (s2.empty()) {
            while (!s1.isEmpty()) {
                s2.add(s1.pop());
            }
        }

        return s2.peek();
    }

    public boolean empty() {
        return size == 0;
    }
}
