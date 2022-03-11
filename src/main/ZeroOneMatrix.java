package main;

/*
    542. 01 Matrix

    Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

    The distance between two adjacent cells is 1.
 */

import java.util.*;

public class ZeroOneMatrix {
    public static void main (String[] args) {
        ZeroOneMatrix z = new ZeroOneMatrix();
        Set<Pair> set = new HashSet<>();
        set.add(new Pair(1,2));
         int[][] res = new int[][]{{0,1,1},{1,1,1},{1,1,1}};
        // int[][] res = new int[][]{{0,0,0},{0,1,1 },{0,0,0}};
        // int[][] res = new int[][]{{0,0,0},{0,1,0 },{1,1,1}};
        z.updateMatrix(res);
        System.out.println(set.contains(new Pair(1,2)));
    }

    private static class Pair {
        int row ;
        int col ;

        public Pair(int row, int col) {
            this.row=row;
            this.col=col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return row == pair.row && col == pair.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    private static final int VISITED = Integer.MAX_VALUE;
    private static final List<int[]> DIRECTIONS = Arrays.asList(new int[][] {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    });

    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();

        for (int row = 0 ; row < mat.length ; row++) {
            for (int col = 0 ; col < mat[row].length ; col++) {
                if (mat[row][col] == 0) {
                    q.offer(new int[]{row,col});
                }
            }
        }

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0 ; i < size ; i++) {
                int[] curr = q.poll();
                int currRow = curr[0];
                int currCol = curr[1];

                mat[currRow][currCol] = level;

                visited.add(new Pair(currRow, currCol));

                for (int[] dir : DIRECTIONS) {
                    int newRow = currRow + dir[0];
                    int newCol = currCol + dir[1];

                    if (newRow < 0 || newRow >= mat.length || newCol < 0 || newCol >= mat[newRow].length) {
                        continue;
                    }

                    Pair currPair = new Pair(newRow, newCol);

                    if (!visited.contains(currPair) && mat[newRow][newCol] != 0) {
                        q.offer(new int[] {newRow, newCol});
                        visited.add(currPair);
                    }
                }
            }

            level++;
        }
        return mat;
    }
}
