package main;

import java.util.Arrays;

/*
    733. Flood Fill

    An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

    You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

    To perform a flood fill, consider the starting pixel,
    plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
    plus any pixels connected 4-directionally to those pixels (also with the same color), and so on.
    Replace the color of all the aforementioned pixels with newColor.

    Return the modified image after performing the flood fill.
 */
public class FloodFill {
    public static void main(String[] args) {
        FloodFill f = new FloodFill();
        // int[][] image = new int[][]{{1,1,1}, {1,1,0}, {1,0,1}};
        int[][] image = new int[][]{{0,0,0}, {0,1,1}};
        int[][] res = f.floodFill(image, 1, 1, 1);
        Arrays.toString(res);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // if the starting point is the same as newColor, don't do anything.
        if (image[sr][sc] == newColor) {
            return image;
        }

        flood(sc, sr, newColor, image[sr][sc], image);
        return image;
    }

    public void flood(int x, int y, int newColor, int startColor, int[][] image) {

        if ( y < 0 || y >= image.length || x < 0 || x >= image[0].length || image[y][x] != startColor) {
            return;
        }
        image[y][x] = newColor;

        // recurse down
        flood(x, y + 1, newColor, startColor, image);
        // recurse top
        flood(x, y - 1, newColor, startColor, image);
        // recurse right
        flood(x + 1, y, newColor, startColor, image);
        // recurse left
        flood(x - 1, y, newColor, startColor, image);

    }

    /*
    public void flood(int x, int y, int newColor, int startColor, int[][] image) {

        if (image[y][x] == startColor) {
            image[y][x] = newColor;

            // recurse left
            if (x - 1 >= 0 && x != image[0].length - 1) {
                flood(x - 1, y, newColor, startColor, image);
            }

            // recurse right
            if (x + 1 < image[0].length && x != 0) {
                flood(x + 1, y, newColor, startColor, image);
            }

            // recurse top
            if (y - 1 >= 0 && y != image.length - 1) {
                flood(x, y - 1, newColor, startColor, image);
            }

            // recurse down
            if (y + 1 < image.length && y != 0) {
                flood(x, y + 1, newColor, startColor, image);
            }
        }
    }

     */
}
