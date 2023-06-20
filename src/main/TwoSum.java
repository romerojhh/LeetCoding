package main;

/* 1. Two Sum

 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
import java.util.*;
public class TwoSum {

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] res = ts.twoSum(new int[]{2,11,15, 7}, 9);
        System.out.println(Arrays.toString(res));
    }

    // o(n^2)
//    public int[] twoSum(int[] nums, int target) {
//        // 2, 7, 11, 15 -> [0, 1]
//        for (int i = 0 ; i < nums.length ; i++) {
//            int firstVal = nums[i];
//            for (int j = i + 1 ; j < nums.length; j++) {
//                int secondVal = nums[j];
//                if (firstVal + secondVal == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[]{};
//    }

    // O(n)
    public int[] twoSum(int[] nums, int target) {
        // target = 9
        // 2, 7, 11, 15 -> [0, 1]
        // 7, 2
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            int diff = target - nums[i];
            if (!hm.containsKey(nums[i])) {
                hm.put(diff, i);
            } else {
                return new int[]{i, hm.get(nums[i])};
            }
        }
        return new int[]{};
    }
}
