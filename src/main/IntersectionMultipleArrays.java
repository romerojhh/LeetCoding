package main;

import java.util.*;

/* 2248. Intersection of Multiple Arrays

Given a 2D integer array nums where nums[i] is a non-empty array of distinct positive integers,
return the list of integers that are present in each array of nums sorted in ascending order.
 */
public class IntersectionMultipleArrays {
    public static void main(String[] args) {
        IntersectionMultipleArrays i = new IntersectionMultipleArrays();
        int[][] a = new int[][]{{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
        System.out.println(i.intersection(a));
    }

    public List<Integer> intersection(int[][] nums) {
        List<Integer> l = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] intArr : nums) {
            for (int currInt: intArr) {
                if (!map.containsKey(currInt)) {
                    map.put(currInt, 1);
                } else {
                    map.put(currInt, map.get(currInt) + 1);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == nums.length) {
                l.add(entry.getKey());
            }
        }

        Collections.sort(l);
        return l;
    }
}
