package main;

import java.util.Arrays;

/* 977. Squares of a Sorted Array

Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in non-decreasing order.

 */
public class SquaresOfSortedArray {
    public static void main(String[] args) {
        SquaresOfSortedArray s = new SquaresOfSortedArray();
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-5,-3,-2,-1})));
    }

    public int[] sortedSquares(int[] nums) {
        // -4,-1,0,3,10
        // -4,-1 | 0,3,10
        // 16, 1, 0, 9, 100
        // 0, 1, 9, 16, 100
        if (nums == null) {
            return null;
        } else if (nums.length == 0) {
            return new int[]{};
        }

        int[] res = new int[nums.length];

        int midIdx = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                midIdx = i;
                break;
            }
        }

        // all negative
        if (midIdx == -1) {
            // i = 0 1 2 3 4
            // 1 2 3 4 5
            //
            for (int i = nums.length - 1; i >= 0; i--) {
                res[nums.length - 1 - i] = (int)Math.pow(nums[i], 2);
            }
        } else {
            int goLeft = midIdx - 1;
            int goRight = midIdx;
            int resIdx = 0;
            while (goLeft >= 0 && goRight < nums.length) {
                if (Math.abs(nums[goLeft]) > Math.abs(nums[goRight])) {
                    res[resIdx++] = (int)Math.pow(nums[goRight++], 2);
                } else {
                    res[resIdx++] = (int)Math.pow(nums[goLeft--], 2);
                }
            }

            for (int i = goLeft; i >= 0; i--) {
                res[resIdx++] = (int)Math.pow(nums[i], 2);
            }

            for (int i = goRight; i < nums.length; i++) {
                res[resIdx++] = (int)Math.pow(nums[i], 2);
            }
        }

        return res;
    }
}
