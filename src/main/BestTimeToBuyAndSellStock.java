package main;

/*
    problem # 121

    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock
    and choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */


// note that selling stock can't happen before buying the stuck
// Prioritize cheap stock
// sell when it's high

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock max = new BestTimeToBuyAndSellStock();

        // System.out.println(max.maxProfit(new int[] {2,4,1}));
        System.out.println(max.maxProfit(new int[] {2,3,5,7,1,10,3,11}));

    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int diff = 0;

        for (int i = 0 ; i < prices.length ; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                int currDiff = prices[i] - min;
                diff = Math.max(currDiff, diff);
            }
        }

        return diff;
    }
}
