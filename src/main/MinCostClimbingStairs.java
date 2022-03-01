package main;

/*
    746. Min Cost Climbing Stairs

    You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
    Once you pay the cost, you can either climb one or two steps.

    You can either start from the step with index 0, or the step with index 1.

    Return the minimum cost to reach the top of the floor.
 */

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairs m = new MinCostClimbingStairs();
        System.out.println(m.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
        System.out.println(m.minCostClimbingStairs(new int[]{0,1,2,2}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];

        if (n <= 2) {
            return Math.min(first, second);
        }

        for (int i = 2; i < n; i++) {
            int temp = cost[i] + Math.min(first,second);
            first = second;
            second = temp;
        }

        return Math.min(first, second);

    }

    /*
    public int minCost(int n, int[] cost, int[] minCostArr) {

        if (n == 0) {
            return minCostArr[0];
        } else if (n == 1) {
            return minCostArr[1];
        }

        for (int i = 2 ; i < n ; i++) {
            minCostArr[i] = minCostArr[i] + Math.min(minCost(i-1, cost, minCostArr), minCost(i-2,cost, minCostArr));
        }

        return minCostArr[minCostArr.length - 1];
    }
    /*
    public int minCostClimbingStairs(int[] cost) {
        int sum1 = traverseAlgo(cost, 0);
        int sum2 = traverseAlgo(cost, 1);

        return Math.min(sum1,sum2);
    }

    public int traverseAlgo(int[] cost, int startIdx) {
        int totalStepSum = cost[startIdx];

        for (int i = startIdx ; i < cost.length - 2 ; i++) {
            int costSumFirst = cost[i] + cost[i + 1];
            int costSumSecond = cost[i] + cost[i + 2];

            if (costSumFirst == costSumSecond) {
                totalStepSum += cost[i + 2];
                i++;
                continue;
            }

            if (costSumFirst > costSumSecond) {
                // only sum up the cheapest cost
                totalStepSum += cost[i + 2];

                i++;

                continue;
            } else {
                totalStepSum += cost[i + 1];
            }

        }

        return totalStepSum;
    }

     */
}
