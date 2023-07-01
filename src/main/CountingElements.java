package main;

import java.util.HashSet;
import java.util.Set;

/* 1426. Counting Elements

Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr.
If there are duplicates in arr, count them separately.

 */
public class CountingElements {
    public static void main(String[] args) {
        CountingElements c = new CountingElements();
        System.out.println(c.countElements(new int[]{1,2,3}));
        System.out.println(c.countElements(new int[]{1,1,3,3,5,5,7,7}));
    }

    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int counter = 0;
        for (int j : arr) {
            set.add(j);
        }

        for (int i : arr) {
            if (set.contains(i + 1)) {
                counter++;
            }
        }

        return counter;
    }
}
