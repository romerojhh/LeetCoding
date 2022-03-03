package main;

/*
    338. Counting Bits

    Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
    ans[i] is the number of 1's in the binary representation of i.
 */
public class CountingBits {
    public static void main (String[] args) {
        CountingBits c = new CountingBits();
        int[] res = c.countBits(10);
        System.out.println(res);
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;

        for (int i = 1 ; i < res.length ; i++) {
            res[i] = res[(i-1) & i] + 1;
        }

        return res;
    }
}
