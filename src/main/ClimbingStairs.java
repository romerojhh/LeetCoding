package main;

/*
    70. Climbing Stairs

    You are climbing a staircase. It takes n steps to reach the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs c = new ClimbingStairs();
        System.out.println(c.climbStairs(4));
    }

    public int climbStairs(int n) {
        int[] arr = new int[45];
        arr[0] = 1;
        arr[1] = 2;
        helper(n, arr);
        return arr[n-1];
    }

    public void helper(int n, int[] arr) {
        for (int i = 2 ; i < n ; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
    }
}
