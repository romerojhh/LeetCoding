package main;

/*
    167. Two Sum II - Input Array Is Sorted

    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
    find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2]
    where 1 <= index1 < index2 <= numbers.length.

    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

    The tests are generated such that there is exactly one solution. You may not use the same element twice.

    Your solution must use only constant extra space.

 */

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        TwoSumII t = new TwoSumII();

        int[] res = t.twoSum(new int[]{2,7,11,19,22}, 30);
        System.out.println(Arrays.toString(res));
    }

    /*
        Basically the algorithm will have two pointers at the front and at the end of the array
        If the sum of the element in left bound and the right bound is bigger than the target -> decrement the right bound
        If the sum is lesser than the target -> increment the left bound
     */
    public int[] twoSum(int[] numbers, int target) {
        int leftBound = 0;
        int rightBound = numbers.length - 1;

        for (int i = 0 ; i < numbers.length; i++) {
            if (numbers[rightBound] + numbers[leftBound] == target) {
                return new int[]{leftBound + 1, rightBound + 1};
            } else if (numbers[rightBound] + numbers[leftBound] > target) {
                rightBound--;
            } else {
                leftBound++;
            }
        }

        return null;
    }
}
