package main;

import java.util.LinkedList;
import java.util.Queue;

/*
    346. Moving Average from Data Stream

    Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

    Implement the MovingAverage class:

    MovingAverage(int size) Initializes the object with the size of the window size.
    double next(int val) Returns the moving average of the last size values of the stream.

 */
public class MovingAverage {
    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }

    Queue<Integer> q;
    int maxSize;

    public MovingAverage(int size) {
        q = new LinkedList<>();
        maxSize = size;
    }

    public double next(int val) {
        q.offer(val);
        if (q.size() > maxSize) {
            q.poll();
        }
        int sum = 0;
        for (Integer i : q) {
            sum += i;
        }
        return (double) sum / q.size();
    }
}
