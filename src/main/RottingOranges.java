package main;

/*
    994. Rotting Oranges

    You are given an m x n grid where each cell can have one of three values:

        0 representing an empty cell,
        1 representing a fresh orange, or
        2 representing a rotten orange.

    Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

    Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */

import java.util.*;

public class RottingOranges {
    public static void main (String[] args) {
        RottingOranges r = new RottingOranges();
        // int[][] res = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        // int[][] res = new int[][]{{2,2},{1,1},{0,0},{2,0}};
        // [[2,2],[1,1],[0,0],[2,0]]


        int[][] res = new int[][]{
                {2,0,1,1,1,1,1,1,1,1},
                {1,0,1,0,0,0,0,0,0,1},
                {1,0,1,0,1,1,1,1,0,1},
                {1,0,1,0,1,0,0,1,0,1},
                {1,0,1,0,1,0,0,1,0,1},
                {1,0,1,0,1,1,0,1,0,1},
                {1,0,1,0,0,0,0,1,0,1},
                {1,0,1,1,1,1,1,1,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1}};

        int asd = r.orangesRotting(res);
        System.out.println(asd);
    }

    private static final List<int[]> DIRECTIONS = Arrays.asList(new int[][] {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    });

    private static final int VISITED = Integer.MAX_VALUE;
    private static final int ROTTEN = 2;
    private static final int FRESH = 1;
    private static final int EMPTY = 0;

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int minuteElapsed = 0;
        int freshOrange = 0;
        // find the rotten fruit coordinate and put to Queue
        for (int row = 0 ; row < grid.length ; row++) {
            for (int col = 0 ; col < grid[row].length ; col++) {
                if (grid[row][col] == ROTTEN) {
                    q.offer(new int[]{row, col});
                } else if (grid[row][col] == FRESH) {
                    freshOrange++;
                }
            }
        }

        if (freshOrange == 0) {
            return 0;
        }

        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0 ; i < qSize ; i++) {
                int[] curr = q.poll();

                int currRow = curr[0];
                int currCol = curr[1];

                for (int[] arr : DIRECTIONS) {
                    int newRow = currRow + arr[0];
                    int newCol = currCol + arr[1];

                    if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[newRow].length) {
                        continue;
                    }

                    int[] newCoordinate = new int[]{newRow, newCol};
                    if (grid[newRow][newCol] == FRESH) {
                        grid[newRow][newCol] = ROTTEN;
                        q.offer(newCoordinate);
                    }
                }
            }

            minuteElapsed++;
        }

        for (int row = 0 ; row < grid.length ; row++) {
            for (int col = 0 ; col < grid[row].length ; col++) {
                if (grid[row][col] == FRESH) {
                    return -1;
                }
            }
        }

        return minuteElapsed == 0 ? 0 : minuteElapsed - 1;
    }
}
