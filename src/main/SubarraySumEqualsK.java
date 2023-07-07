package main;

import java.util.HashMap;
import java.util.Map;

/* 560. Subarray Sum Equals K

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
//        System.out.println(s.subarraySum(new int[]{1,1,1}, 2)); // 2
//        System.out.println(s.subarraySum(new int[]{1,2,3}, 3)); // 2
//        System.out.println(s.subarraySum(new int[]{1,-1,1}, 0)); // 2
//        System.out.println(s.subarraySum(new int[]{1,-1,0}, 0)); // 3
//        System.out.println(s.subarraySum(new int[]{0}, 0)); // 1
        System.out.println(s.subarraySum(new int[]{2, 1, -3, 0, 0, 3}, 3)); // 1
    }

    // this question is a combination of TwoSum + HashMap + PrefixSum
    public int subarraySum(int[] nums, int k) {
        // 1, 2, 1, 2, 1 | k = 3
        // 1, 3, 4, 6, 7 | k = 3

        // 1 0 1 | k = 0

        // 1, 0, 0 | k = 0
        int count = 0;

        // Prefix -> frequency
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1); // For empty subarray

        int total = 0;
        for (int i : nums) {
            total += i;
            if (map.containsKey(total - k)) {
                count += map.get(total - k);
            }
            map.put(total, map.getOrDefault(total, 0) + 1);
        }

        return count;
    }
}
