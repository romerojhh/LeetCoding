package main;

/*
    279. Perfect Squares

    Given an integer n, return the least number of perfect square numbers that sum to n.

    A perfect square is an integer that is the square of an integer;
    in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */
public class PerfectSquares {
    public static void main (String[] args) {
        PerfectSquares p = new PerfectSquares();
        System.out.println(p.numSquares(13));
    }

    public int numSquares(int n) {
        // We need to know how many squared numbers can fit into n

        // base case
        if (n <= 3) {
            return n;
        }

        // Initializing dp array
        int[] dp = new int[n + 1];

        // initialize array
        for (int i = 0 ; i < dp.length ; i++) {
            dp[i] = i;
        }

        dynamic(dp, 4);

        return dp[dp.length - 1];
    }

    private void dynamic(int[] dp, int n) {

        if (n < dp.length) {
            for (int i = 1 ; Math.pow(i, 2) <= n ; i++) {
                int squared = (int) Math.pow(i,2);
                dp[n] = Math.min(dp[n - squared] + 1, dp[n]);
            }
            dynamic(dp, n + 1);
        }

    }
}
