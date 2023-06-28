package main;

/* 1413. Minimum Value to Get Positive Step by Step Sum

    Given an array of integers nums, you start with an initial positive value startValue.

    In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

    Return the minimum positive value of startValue such that the step by step sum is never less than 1.
 */
public class MinimumValueGetPositiveStepByStepSum {
    public static void main(String[] args) {
        MinimumValueGetPositiveStepByStepSum m = new MinimumValueGetPositiveStepByStepSum();
        System.out.println(m.minStartValue(new int[]{-3,2,-3,4,2}));
        System.out.println(m.minStartValue(new int[]{2,3,4,5,1}));
        System.out.println(m.minStartValue(new int[]{1,-2,-3}));
        System.out.println(m.minStartValue(new int[]{-5,-6,-2}));
        System.out.println(m.minStartValue(new int[]{2,3,5,-5,-1}));
    }

    public int minStartValue(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 2,5,10,5,4
        int[] prefixSum = new int[nums.length];
        int smallest = nums[0];
        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
            smallest = Math.min(smallest, prefixSum[i]);
        }

        if (smallest > 0) {
            return 1;
        }

        return Math.abs(smallest) + 1;
    }
}
