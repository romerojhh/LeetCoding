package main;

/* 643. Maximum Average Subarray I

You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
Any answer with a calculation error less than 10-5 will be accepted.

*/
public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        MaximumAverageSubarrayI m = new MaximumAverageSubarrayI();
        System.out.println(m.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.println(m.findMaxAverage(new int[]{5}, 1));
        System.out.println(m.findMaxAverage(new int[]{-1}, 1));
    }

    public double findMaxAverage(int[] nums, int k) {
        // length equals to k
        // has maximum average value
        if (nums == null || k < 1 || nums.length < k) {
            return 0;
        }
        int left = 0;
        double maxAvg = Integer.MIN_VALUE;
        double curr = 0;
        boolean keepDoing = k == 1;
        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            if (keepDoing || right > 0 && right % (k - 1) == 0) {
                // when right is a multiple of k

                // calculate maxAvg
                maxAvg = Math.max(maxAvg, curr / k);

                // increment left i.e., decrement curr with nums[left++]
                curr -= nums[left++];

                keepDoing = true;
            }
        }

        return maxAvg;
    }
}
