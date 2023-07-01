package main;

import java.util.HashSet;
import java.util.Set;

/* 268. Missing Number

Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.

 */
public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber m = new MissingNumber();
        System.out.println(m.missingNumber(new int[]{3,0,1}));
    }

    public int missingNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i <= nums.length; i++) {
            set.add(i);
        }

        for (int num : nums) {
            set.remove(num);
        }
        Integer[] s = set.toArray(new Integer[1]);
        return s[0];
    }
}
