package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 163. Missing Ranges
    You are given an inclusive range [lower, upper] and a sorted unique integer array nums,
    where all elements are within the inclusive range.

    A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

    Return the shortest sorted list of ranges that exactly covers all the missing numbers.
    That is, no element of nums is included in any of the ranges, and each missing number is covered by one of the ranges.
 */
public class MissingRanges {
    public static void main(String[] args) {
        MissingRanges m = new MissingRanges();
        System.out.println(m.findMissingRanges(new int[]{0,1,3,50,75}, 0, 99));
        System.out.println(m.findMissingRanges(new int[]{-1}, -1, -1));
        System.out.println(m.findMissingRanges(new int[]{5}, 0, 100));
        System.out.println(m.findMissingRanges(new int[]{}, 0, 100));
    }

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        /*
            Input: nums = [0,1,3,50,75], lower = 0, upper = 99
            Output: [[2,2],[4,49],[51,74],[76,99]]
         */
        List<List<Integer>> ll = new LinkedList<>();
        if (nums.length == 0) {
            ll.add(Arrays.asList(lower, upper));
            return ll;
        }

        // diff has to be always 1
        int diff = 0;
        int curr = nums[0];
        int prev = lower - 1;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == lower) {
                prev = curr;
                continue;
            }

            curr = nums[right];
            diff = Math.abs(curr - prev);
            if (diff != 1) {
                ll.add(Arrays.asList(prev + 1, curr - 1));
            }

            prev = curr;
        }

        // check end bounds
        if (nums[nums.length - 1] != upper) {
            ll.add(Arrays.asList(prev + 1, upper));
        }

        return ll;
    }
}
