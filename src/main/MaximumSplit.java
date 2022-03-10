package main;

import java.util.ArrayList;
import java.util.List;

/*
    2178. Maximum Split of Positive Even Integers

    You are given an integer finalSum. Split it into a sum of a maximum number of unique positive even integers.

    For example, given finalSum = 12, the following splits are valid (unique positive even integers summing up to finalSum):
    (12), (2 + 10), (2 + 4 + 6), and (4 + 8). Among them, (2 + 4 + 6) contains the maximum number of integers.
    Note that finalSum cannot be split into (2 + 2 + 4 + 4) as all the numbers should be unique.

    Return a list of integers that represent a valid split containing a maximum number of integers.
    If no valid split exists for finalSum, return an empty list. You may return the integers in any order.
 */
public class MaximumSplit {
    public static void main (String[] args) {
        MaximumSplit m = new MaximumSplit();
        List<Long> l = m.maximumEvenSplit(12);
    }

    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 != 0) {
            return new ArrayList<>();
        }

        List<Long> list = new ArrayList<>();
        // The number inside the list can't be bigger than finalSum
        // The number inside the list are unique and EVEN
        long currNum = 2;
        long currState = 0;

        while (currState <= finalSum) {
            currState += currNum;
            list.add(currNum);
            currNum += 2;

        }

        long diff = currState - finalSum;
        list.remove(diff);

        return list;
    }
}
