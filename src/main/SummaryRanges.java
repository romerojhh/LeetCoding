package main;

import java.util.ArrayList;
import java.util.List;

/*
    Problem # 228

    You are given a sorted unique integer array nums.

    Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
    That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

    Each range [a,b] in the list should be output as:

    "a->b" if a != b
    "a" if a == b
 */
public class SummaryRanges {

    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();

        // [-2147483648,-2147483647,2147483647]
        List<String> l = sr.summaryRanges(new int[]{-2147483648,-2147483647,2147483647});

        for (String s : l ) {
            System.out.println(s);
        }
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return new ArrayList<>();
        }

        List<String> l = new ArrayList<>();
        int startVal = nums[0];
        int prevVal = nums[0];

        for (int i = 1 ; i < nums.length ; i++) {
            // if the difference between previous value and the current value is > 1. add the previous value to the l
            if (Math.abs(nums[i] - prevVal) > 1) {
                if (startVal == prevVal) {
                    l.add("" + prevVal);
                } else {
                    l.add(String.format("%d->%d", startVal, prevVal));
                }
                startVal = nums[i];
                prevVal = nums[i];
            }
            // else if the difference is <= 1, just update the prevVal!
            else {
                prevVal = nums[i];
            }
        }

        // Below is for the case when adding things at the end!
        if (startVal == prevVal) {
            l.add("" + prevVal);
        } else {
            l.add(String.format("%d->%d", startVal, prevVal));
        }

        return l;
    }

}
