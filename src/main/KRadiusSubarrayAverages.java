package main;

import java.util.Arrays;

/* 2090. K Radius Subarray Averages

You are given a 0-indexed array nums of n integers, and an integer k.

The k-radius average for a subarray of nums centered at some index i with the radius k
is the average of all elements in nums between the indices i - k and i + k (inclusive).
If there are less than k elements before or after the index i, then the k-radius average is -1.

Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.

The average of x elements is the sum of the x elements divided by x, using integer division.
The integer division truncates toward zero, which means losing its fractional part.

For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.

 */
public class KRadiusSubarrayAverages {
    public static void main(String[] args) {
        KRadiusSubarrayAverages k = new KRadiusSubarrayAverages();
        System.out.println(Arrays.toString(k.getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 3)));
    }

    public int[] getAverages(int[] nums, int k) {
        int[] avgArr = new int[nums.length];

        // create and initialize prefix array
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        // (int) Math.floor(sum / count)
        // 7,4,3,9,1,8,5,2,6
        // 7,11,14 |,23,24,32,| 37,39,45
        // 7,11 | 14,23,24,32,37 |39,45
        // k = 3
        // window size = 7
        // bottomThreshold = k - 1
        // topThreshold = len - k
        // if (bottom >= top) -> all value -1

        // window size = k * 2 + 1
        long windowSize = k * 2L + 1;

        // If there are less than k elements before or after the index i, then the k-radius average is -1.
        long bottomThreshold = k - 1;
        long topThreshold = nums.length - k;
        if (bottomThreshold >= topThreshold) {
            for (int i = 0; i < nums.length; i++) {
                avgArr[i] = -1;
            }
            return avgArr;
        }

        for (int i = 0; i < nums.length; i++) {
           if (i <= bottomThreshold || i >= topThreshold) {
               avgArr[i] = -1;
           } else {
               int removeIdx = i - k - 1;
               if (removeIdx >= 0) {
                   avgArr[i] = (int) ((prefix[i + k] - prefix[removeIdx]) / windowSize);
               } else {
                   // if idx = 5 but get prefix value from idx + k = 5 + 3 = 8
                   avgArr[i] = (int) (prefix[i + k] / windowSize);
               }
           }
        }

        return avgArr;
    }
}
