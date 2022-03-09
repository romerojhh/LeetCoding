package main;

/*
    494. Target Sum

    You are given an integer array nums and an integer target.

    You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

        For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".

    Return the number of different expressions that you can build, which evaluates to target.
 */
public class TargetSum {
    public static void main(String[] args) {
        TargetSum t = new TargetSum();
        System.out.println(t.findTargetSumWays(new int[]{1,1,1,1,1} , 3));
    }

    int totalValid = 0;

    public int findTargetSumWays(int[] nums, int target) {
        // each elements have 2 possibilities of being positive or negative
        helper(target, nums, 0, 0);
        return totalValid;
    }

    private void helper(int target, int[] nums, int currIdx, int currSum) {


        // We only want to check at the end of the recursion whether it equals to target or not.

        if (currIdx < nums.length) {
            // negative version
            helper(target, nums, currIdx + 1,currSum + nums[currIdx] * -1);

            // positive version
            helper(target, nums, currIdx + 1, currSum + nums[currIdx]);
        }

        if (currSum == target && currIdx == nums.length) {
            totalValid++;
        }
    }
}
