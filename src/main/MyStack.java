package main;

import java.util.LinkedList;
import java.util.Queue;

/*
    225. Implement Stack using Queues

    Implement a last-in-first-out (LIFO) stack using only two queues.
    The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 */
public class MyStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(1);
        System.out.println(stack.top());
    }

    Queue<Integer> q1;
    Queue<Integer> q2;
    int size;

    public MyStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
        this.size = 0;
    }

    public void push(int x) {
        // we always push things to the non-empty queue
        if (!q1.isEmpty()) {
            q1.offer(x);
        } else {
            q2.offer(x);
        }
        size++;
    }

    public int pop() {
        if (empty()) {
            throw new IllegalStateException();
        }
        // First we need to transfer all things from the non-empty queue to the empty queue except the last element
        if (!q1.isEmpty()) {
            int stackSize = q1.size();
            for (int i = 0 ; i < stackSize - 1; i++) {
                q2.offer(q1.poll());
            }
            size--;
            return q1.poll();
        } else {
            int stackSize = q2.size();
            for (int i = 0 ; i < stackSize - 1; i++) {
                q1.offer(q2.poll());
            }
            size--;
            return q2.poll();
        }
    }

    public int top() {
        if (empty()) {
            throw new IllegalStateException();
        }
        // First we need to transfer all things from the non-empty queue to the empty queue except the last element
        int ans = -1;

        if (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0 ; i < size ; i++) {
                if (i == size - 1) {
                    ans = q1.peek();
                }
                q2.offer(q1.poll());
            }

        } else {
            int size = q2.size();
            for (int i = 0 ; i < size; i++) {
                if (i == size - 1) {
                    ans = q2.peek();
                }
                q1.offer(q2.poll());
            }
        }

        return ans;
    }

    public boolean empty() {
        return size == 0;
    }
}
