package main;

import java.util.Arrays;

/*
    283. Move Zeroes
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes m = new MoveZeroes();
        int[] arr = new int[]{0,1,0,3,12};
        m.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 0; i < nums.length ; i++) {

            // if the current element is 0, then we want to find the next non-zero element
            if (nums[i] == 0) {
                int j = i;

                boolean foundNonZero = false;
                while (j < nums.length && !foundNonZero) {
                    if (nums[j] != 0) {
                        foundNonZero = true;
                    } else {
                        j++;
                    }
                }

                if (!foundNonZero) {
                    return;
                }

                // Got the next occurence of non-zero.
                int nonZero = nums[j];

                // swap
                nums[i] = nonZero;
                nums[j] = 0;
            }
        }
    }
}
