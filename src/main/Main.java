package main;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] input = new int[]{1,2,3};
        List<List<Integer>> ll = p.permute(input);

        for (List<Integer> l : ll) {
            System.out.println(l.toString());
        }
    }
}
