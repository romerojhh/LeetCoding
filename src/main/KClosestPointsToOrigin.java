package main;

import java.util.*;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 */

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        KClosestPointsToOrigin k1 = new KClosestPointsToOrigin();
        int[][] test = { {5,-1}, {-3,3}, {3,-3}};
        int[][] res = k1.kClosest(test, 2);
        for (int[] i : res) {
            System.out.println("X: " + i[0] + ", Y: " + i[1]);
        }
    }

    private int distance(int[] in) {
        return (int) (Math.pow(in[0], 2) + Math.pow(in[1], 2));
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return distance(o2) - distance(o1);
            }
        });

        for (int[] coord: points) {
            heap.add(coord);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }

    /**
    public int[][] kClosest(int[][] points, int k) {
        // Priority queue to store k closest coordinate to (0,0)
        // will store the highest coordinate, every time we insert something
        // to the heap.

        // Reverse order for max-heap
        PriorityQueue<Double> distPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> idxQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            // Get the distance
            double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));


            if (distPq.size() == k) {
                if (distPq.peek() > distance) {
                    distPq.poll();
                    idxQ.poll();
                    distPq.add(distance);
                    idxQ.add(i);
                }
            } else {
                distPq.add(distance);
                idxQ.add(i);
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        for (int index : idxQ) {
            res[i][0] = points[index][0];
            res[i++][1] = points[index][1];
        }

        return res;
    }
     **/

}
