package main;

import java.util.Arrays;

/* 1480. Running Sum of 1d Array
    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    Return the running sum of nums.
 */
public class RunningSum1dArray {
    public static void main(String[] args) {
        RunningSum1dArray r = new RunningSum1dArray();
        System.out.println(Arrays.toString(r.runningSum(new int[]{1,2,3,4})));
    }

    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length == 0) {
            return res;
        }
        res[0] = nums[0];
        if (nums.length == 1) {
            return res;
        }
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] + nums[i];
        }

        return res;
    }
}
