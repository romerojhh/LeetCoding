package main;

/* 2270. Number of Ways to Split Array

You are given a 0-indexed integer array nums of length n.

nums contains a valid split at index i if the following are true:
    - The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.
    - There is at least one element to the right of i. That is, 0 <= i < n - 1.

Return the number of valid splits in nums.

 */
public class NumberOfWaysToSplitArray {
    public static void main(String[] args) {
        NumberOfWaysToSplitArray n = new NumberOfWaysToSplitArray();
        System.out.println(n.waysToSplitArray(new int[]{10,4,-8,7}));
        System.out.println(n.waysToSplitArray(new int[]{2,3,1,0}));
        System.out.println(n.waysToSplitArray(new int[]{-100,200,3,1,2}));
        System.out.println(n.waysToSplitArray(new int[]{2,3}));
    }

    public int waysToSplitArray(int[] nums) {
        // 10, 14, 6, 13
        // 13, 3, -1, 7

        // 7, -1, 3, 13
        if (nums.length == 0) {
            return 0;
        }
        // n = length of nums 5
        // i = 2
        // 0 -> 2 >= 4 -> 3
        // 0 -> i >= n - 1 -> n - i
        // bidirectional prefix sum?
        int validCount = 0;
        int n = nums.length;

        // make right direction prefix
        long[] rightPrefix = new long[n];
        rightPrefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            rightPrefix[i] = rightPrefix[i - 1] + nums[i];
        }

        // make left direction prefix
        long[] leftPrefix = new long[n];
        leftPrefix[n-1] = nums[n-1];
        for (int i = n - 2; i >= 0; i--) {
            leftPrefix[i] = leftPrefix[i + 1] + nums[i];
        }

        // calculate valid split
        for (int i = 0; i < n - 1; i++) {
            if (rightPrefix[i] >= leftPrefix[i+1]) {
                validCount++;
            }
        }

        return validCount;
    }
}
