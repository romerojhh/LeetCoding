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

public class TODORottingOranges {
    public static void main (String[] args) {
        TODORottingOranges r = new TODORottingOranges();
        // int[][] res = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
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

    public int orangesRotting(int[][] grid) {
        int counter = 0;
        for (int row = 0 ; row < grid.length ; row++) {
            for (int col = 0 ; col < grid[row].length ; col++) {
                if (grid[row][col] == 2) {

                    /*
                    expandRot(grid, row + 1, col);
                    expandRot(grid, row - 1, col);
                    expandRot(grid, row, col + 1);
                    expandRot(grid, row, col - 1);

                     */
                    boolean down = expandRot(grid, row + 1, col);
                    boolean up = expandRot(grid, row - 1, col);
                    boolean right = expandRot(grid, row, col + 1);
                    boolean left = expandRot(grid, row, col - 1);
                    if ( down || up || right  || left) {
                        counter++;
                    }

                }
            }
        }

        for (int row = 0 ; row < grid.length ; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }
        return counter;
    }

    private boolean expandRot(int[][] grid, int startRow, int startCol) {

        if (startRow < 0 || startRow >= grid.length || startCol < 0 || startCol >= grid[startRow].length ||
                grid[startRow][startCol] == 0 || grid[startRow][startCol] == 2) {
            return false;
        }

        grid[startRow][startCol] = 2;
        return true;
    }
}
