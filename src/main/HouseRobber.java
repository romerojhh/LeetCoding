package main;

/*
    198. House Robber

    You are a professional robber planning to rob houses along a street.
    Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that
    adjacent houses have security systems connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

    Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */

// ------------TIPS------------
//    This particular problem and most of others can be approached using the following sequence:
//
//    1)  Find recursive relation -> in the terms of previous state instead of future state
//    2)  Recursive (top-down)
//    3)  Recursive + memo (top-down)
//    4)  Iterative + memo (bottom-up)
//    5)  Iterative + N variables (bottom-up)
//-------------------------------

// If a robber see a house(n) he have 2 options
//      1) Rob the house -> have to come from at least n-2 in order not to alert police
//      2) Pass the house; this means that he got the loot from the previous n-1 houses
// So,
//      it will be
//      1) currentHouseValue + rob(n-2) or
//      2) rob(n - 1)
//      Decide which one is the one that is bigger
public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
        // System.out.println(h.rob(new int[]{2,7,9,3,1}));
        System.out.println(h.rob(new int[]{2,1,1,2,5,10,12,1,12}));
        System.out.println(h.rob(new int[]{2,1,1,2}));
    }

    public int rob(int[] nums) {
        // extra 1 space for starting point because we don't have 2 base case except the first element from
        // nums array here
        int[] robVal = new int[nums.length + 1];
        robVal[0] = 0;
        robVal[1] = nums[0];

        for (int i = 1 ; i < nums.length ; i++) {
            robVal[i + 1] = Math.max(nums[i] + robVal[i - 1], robVal[i]);
        }

        return robVal[nums.length];
    }
    /*
    public int rob(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0 ; i < nums.length ; i++) {
            int currSum = 0;
            currSum += nums[i];

            int j = i;

            while (j + 2 < nums.length && j + 3 < nums.length) {
                if (nums[j + 2] >= nums[j + 3]) {
                    j += 2;
                } else {
                    j += 3;
                }

                currSum += nums[j];
            }

            if (j + 2 < nums.length) {
                currSum += nums[j + 2];
            }

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

     */
}
