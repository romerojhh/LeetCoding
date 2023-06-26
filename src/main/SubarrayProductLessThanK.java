package main;

/* 713. Subarray Product Less Than K

Given an array of integers nums and an integer k, return the number of contiguous subarrays
where the product of all the elements in the subarray is strictly less than k.
 */
public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        SubarrayProductLessThanK s = new SubarrayProductLessThanK();
//        System.out.println(s.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100)); // expect 8
        System.out.println(s.numSubarrayProductLessThanK(new int[]{1,2,3}, 0)); // expect 0
//        System.out.println(s.numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19)); // expect 18
//        System.out.println(s.numSubarrayProductLessThanK(new int[]{100,2,3,4,100,5,6,7,100}, 100)); // expect 11
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int total = 0;
        if (nums == null || nums.length == 0 || k <= 1) {
            return total;
        }

        int left = 0;
        int product = 1;
        // condition = product in window is < 100
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            total += right - left + 1;
        }

        return total;
    }
}
