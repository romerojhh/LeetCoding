package main;

/*  WORK ON THIS CLASS
    695. Max Area of Island

    You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
    (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

    The area of an island is the number of cells with a value 1 in the island.

    Return the maximum area of an island in grid. If there is no island, return 0.
 */

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        MaxAreaOfIsland m = new MaxAreaOfIsland();
        // System.out.println(m.maxAreaOfIsland(new int[][]{{1,0,1,1}, {1,0,1,1}, {0,0,0,0}, {0,0,0,0}}));
        System.out.println(m.maxAreaOfIsland(new int[][]{{0}, {1}}));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int sum = 0;
        for (int row = 0 ; row < grid.length ; row++) {
            for (int col = 0; col < grid[row].length ; col++) {
                if (grid[row][col] == 1) {
                    sum = Math.max(sum, helper(row, col, 1, grid));
                }
            }
        }
        return sum;
    }

    private int helper (int row, int col, int sum, int[][] grid) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = 0;

        // only add the sum if it's valid
        // sum += 1;
        int recurseUp = helper (row - 1, col, sum, grid);
        int recurseDown = helper (row + 1, col, sum, grid);
        int recurseLeft = helper (row, col - 1, sum, grid);
        int recurseRight = helper (row, col + 1, sum, grid);

        return recurseDown + recurseUp + recurseLeft + recurseRight + sum;

        /*
        return helper (row - 1, col, sum + 1, grid) + helper (row + 1, col, sum + 1, grid) +
                helper (row, col - 1, sum + 1, grid) + helper (row, col + 1, sum + 1, grid);
        /*
        //if (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == 1) {
            // recurse up
            helper (row - 1, col, sum + 1, grid);
            // recurse down
            helper (row + 1, col, sum + 1, grid);
            // recurse left
            helper (row, col - 1, sum + 1, grid);
            // recurse right
            helper (row, col + 1, sum + 1, grid);
        //}

         */
    }
}
