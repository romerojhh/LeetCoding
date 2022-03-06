package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    286. Walls and Gates

    You are given an m x n grid rooms initialized with these three possible values.

    -1 A wall or an obstacle.
    0 A gate.
    INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.

    Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 */
public class WallsAndGates {
    public static void main (String[] args) {
        WallsAndGates w = new WallsAndGates();
        int[][] arr = new int[][] {
                {2147483647,    -1,         0,          2147483647},
                {2147483647,     2147483647, 2147483647, -1},
                {2147483647,     -1,         2147483647, -1},
                {0,              -1,         2147483647, 2147483647}
        };
        w.wallsAndGates(arr);
    }

    // Fill each empty room with the distance to its nearest gate!
    //  [[2147483647,    -1,         0,          2147483647],
    //  [2147483647,     2147483647, 2147483647, -1],
    //  [2147483647,     -1,         2147483647, -1],
    //  [0,              -1,         2147483647, 2147483647]]

    //  [
    //  [3, -1, 0,   1],
    //  [2,  2, 1,  -1],
    //  [1, -1, 2,  -1],
    //  [0, -1, 3,   4]]
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[]{1,0},
            new int[]{-1,0},
            new int[]{0,1},
            new int[]{0,-1}
    );

    public void wallsAndGates(int[][] rooms) {
        // The queue will store coordinates
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0 ; row < rooms.length ; row++) {
            for (int col = 0 ; col < rooms[row].length; col++) {
                // Put all of the gates to the queue
                if (rooms[row][col] == GATE) {
                    q.offer(new int[]{row,col});
                }
            }
        }
        int step = 0;

        // while loop for each level
        while (!q.isEmpty()) {
            int size = q.size();

            // for loop to process each node in the level
            for (int i = 0 ; i < size ; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                if (rooms[row][col] == EMPTY) {
                    rooms[row][col] = step;
                }
                for (int[] dir : DIRECTIONS) {
                    int newRow = dir[0] + row;
                    int newCol = dir[1] + col;
                    if (newRow < 0 || newRow >= rooms.length || newCol < 0 || newCol >= rooms[newRow].length) {
                        continue;
                    }
                    if (rooms[newRow][newCol] == EMPTY) {
                        q.offer(new int[]{newRow,newCol});
                    }
                }
            }
            step++;
        }
    }
}
