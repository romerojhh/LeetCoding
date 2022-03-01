package main;

/*
    1137. N-th Tribonacci Number

    The Tribonacci sequence Tn is defined as follows:

    T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

    Given n, return the value of Tn.
 */
public class NthTribonacci {

    public static void main(String[] args) {
        NthTribonacci t = new NthTribonacci();
        System.out.println(t.tribonacci(37));
    }

    // Runtime exception for code below!
    /*
    public int tribonacci(int n) {
        int realN = n-3;
        if (n == 2) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else {
            return tribonacci(realN) + tribonacci(realN+1) + tribonacci(realN+2);
        }
    }
     */

    // Hint : Make an array F of length 38, and set F[0] = 0, F[1] = F[2] = 1.

    public int tribonacci(int n) {
        int[] fiboArr = new int[38];
        fiboArr[0] = 0;
        fiboArr[1] = 1;
        fiboArr[2] = 1;

        for (int i = 3 ; i <= n ; i++) {
            fiboArr[i] = fiboArr[i - 1] + fiboArr[i - 2] + fiboArr[i - 3];
        }

        return fiboArr[n];
    }
}
