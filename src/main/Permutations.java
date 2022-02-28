package main;

import java.util.ArrayList;
import java.util.List;

// problem # 46
public class Permutations {

    public List<List<Integer>> permute (int[] nums) {
        List<List<Integer>> ll = new ArrayList<>();
        backTrack(ll, new ArrayList<Integer>(), nums);
        return ll;
    }

    private void backTrack (List<List<Integer>> ll , List<Integer> al, int[] nums) {

        // if the array list size is the same as the size of nums,
        // it means that we got the next permutation val
        if (al.size() == nums.length) {
            ll.add(new ArrayList<>(al));
        }
        // else, keep adding more integer to the list
        else {
            for (int i = 0 ; i < nums.length ; i++) {

                // if 'al' already contains the integer, don't add it to the al again.
                if (al.contains(nums[i])) {
                    continue;
                }
                al.add(nums[i]);

                backTrack(ll, al, nums);

                // remove the least recently added element
                al.remove(al.size() - 1);
            }
        }
    }

    //-----------------------------------------------------
    // It's a common backtracking pattern, choose --> explore --> unchoose.
    //
    // BELOW EXPLANATION FOR al.remove(al.size() - 1)
    //
    // @Juan55555 To generate all possible permutations, we need to remove the least recently added element while we are going up the recursive call stack.
    // In the first iteration of the for loop we add all permutations, that start with nums[0].
    // Then, before we can begin building all permutations starting with nums[1], we need to clear the tempList
    // (which currently contains permutations from the first iteration of the for loop) - that's exactly what tempList.remove(tempList.size() - 1) line does.
    //-----------------------------------------------------
}
