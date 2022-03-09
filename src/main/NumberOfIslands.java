package main;

/*
    200. Number of Islands

    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands n = new NumberOfIslands();

        /*
        char[][] arr = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

         */

        char[][] arr = new char[][]{
                {'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
                {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
                {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
                {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
                {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}
        };
        System.out.println(n.numIslands(arr));
    }

    /*
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"]

        Output = 1;

        ["1","1","0","0","0"],
        ["1","1","0","0","0"],
        ["0","0","1","0","0"],
        ["0","0","0","1","1"]

        Output = 3;

     */
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[]{1,0},
            new int[]{-1,0},
            new int[]{0,1},
            new int[]{0,-1}
    );
    private static final char VISITED = 'v';
    private static final char SEA = '0';

    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int numIslands = 0;

        for (int row = 0 ; row < grid.length ; row++) {
            for (int col = 0 ; col < grid[row].length ; col++) {
                if (grid[row][col] != VISITED && grid[row][col] != SEA) {
                    queue.offer(new int[]{row,col});

                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int i = 0 ; i < size ; i++) {
                            int[] curr = queue.poll();
                            int currRow = curr[0];
                            int currCol = curr[1];
                            grid[currRow][currCol] = VISITED;
                            for (int[] arr : DIRECTIONS) {
                                int newRow = currRow + arr[0];
                                int newCol = currCol + arr[1];
                                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[newRow].length) {
                                    continue;
                                }
                                if (grid[newRow][newCol] != SEA && grid[newRow][newCol] != VISITED) {
                                    queue.offer(new int[]{newRow, newCol});
                                    grid[newRow][newCol] = VISITED;
                                }
                            }
                        }
                    }

                    numIslands++;
                }
            }
        }

        return numIslands;
    }
}
