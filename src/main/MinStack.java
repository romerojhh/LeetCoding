package main;

/*
    155. Min Stack

    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    Implement the MinStack class:

        MinStack() initializes the stack object.
        void push(int val) pushes the element val onto the stack.
        void pop() removes the element on the top of the stack.
        int top() gets the top element of the stack.
        int getMin() retrieves the minimum element in the stack.

 */
public class MinStack {
    private class Node {
        int min;
        int val;
        Node next;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    Node head;
    int size;

    public MinStack() {
        this.head = null;
        this.size = 0;
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val);
        } else {
            Node temp = new Node(val, Math.min(head.min, val));
            temp.next = head;
            head = temp;
        }
        size++;
    }

    public void pop() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        head = head.next;
        size--;
    }

    public int top() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        return head.val;
    }

    public int getMin() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        return head.min;
    }
}
