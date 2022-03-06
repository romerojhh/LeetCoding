package main;

/*
    TODO: 542. 01 Matrix

    Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

    The distance between two adjacent cells is 1.
 */

public class TODOZeroOneMatrix {
    public static void main (String[] args) {
        TODOZeroOneMatrix z = new TODOZeroOneMatrix();
        int[][] res = new int[][]{{0,1,1},{1,1,1},{1,1,1}};
        // int[][] res = new int[][]{{0,0,0},{0,1,1 },{0,0,0}};
        // int[][] res = new int[][]{{0,0,0},{0,1,0 },{1,1,1}};
        z.updateMatrix(res);
    }

    public int[][] updateMatrix(int[][] mat) {

    }
    /*
    public int[][] updateMatrix(int[][] mat) {
        for (int row = 0 ; row < mat.length ; row++) {
            for (int col = 0 ; col < mat[row].length ; col++) {
                mat[row][col] = findZero(row, col, mat, 0, false);
            }
        }
        return mat;
    }

    private int findZero(int startRow, int startCol, int[][] mat, int totalRecursion, boolean fromRecurse) {

        if (startRow < 0 || startRow >= mat.length || startCol < 0 || startCol >= mat[startRow].length) {
            return Integer.MAX_VALUE;
        }

        // if the element is not zero, we are going to recurse more
        if (mat[startRow][startCol] != 0) {
            int initialVal = mat[startRow][startCol];
            totalRecursion++;
            mat[startRow][startCol] = 0;
            int recurseDown = findZero(startRow + 1, startCol, mat, totalRecursion, true);
            int recurseUp = findZero(startRow - 1, startCol, mat, totalRecursion, true);
            int recurseRight = findZero(startRow, startCol + 1, mat, totalRecursion, true);
            int recurseLeft = findZero(startRow, startCol - 1, mat, totalRecursion, true);
            mat[startRow][startCol] = initialVal;
            return Math.min(recurseRight, Math.min(recurseUp, Math.min(recurseLeft, recurseDown)));
        } else {
            return totalRecursion;
        }
        // mat[startRow][startCol] = totalRecursion;
    }

     */
}
