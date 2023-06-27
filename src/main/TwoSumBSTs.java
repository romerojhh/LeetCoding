package main;

import java.util.ArrayList;
import java.util.List;

/* 1214. Two Sum BSTs

Given the roots of two binary search trees, root1 and root2,
return true if and only if there is a node in the first tree
and a node in the second tree whose values sum up to a given integer target.

 */
public class TwoSumBSTs {
    public static void main(String[] args) {

    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        // extract the value in the tree into separate lists
        ArrayList<Long> list1 = new ArrayList<>();
        ArrayList<Long> list2 = new ArrayList<>();

        traverse(root1, list1);
        traverse(root2, list2);

        // 1, 2, 4 == 1, 3, 7
        // 0, 1, 3 == 0, 1, 4
        // target = 5
        int longest = Math.max(list1.size(), list2.size());
        ArrayList<Long> ref, bon;

        // ref alwayst longest
        // bon always shortest
        if (list1.size() == longest) {
            ref = list1;
            bon = list2;
        } else {
            ref = list2;
            bon = list1;
        }


        for (int i = 0; i < ref.size(); i++) {
            for (int j = 0; j < bon.size(); j++) {
                if (ref.get(i) + bon.get(j) == target) {
                    return true;
                }
            }
        }

        return false;
    }

    // put value in the tree in order
    private void traverse(TreeNode root, List<Long> list) {
        if (root != null) {
            traverse(root.left, list);
            list.add((long) root.val);
//            if (list.size() == 0) {
//                list.add((long) root.val);
//            } else {
//                list.add(root.val + list.get(list.size() - 1));
//            }

            traverse(root.right, list);
        }
    }

    // Greedy algorithm did not work,
    // need DFS
    public boolean twoSumBSTsVersion1(TreeNode root1, TreeNode root2, int target) {
        // key: binary tree, left < curr, right > curr
        if (root1 == null || root2 == null) {
            return false;
        }

        TreeNode curr1 = root1;
        TreeNode curr2 = root2;

        // traverse both trees at once
        while (curr1 != null && curr2 != null) {
            long currSum = curr1.val + curr2.val;

            if (currSum == target) {
                return true;
            }

            // if sum is too big, we want to subtract -> go left branch
            if (currSum > target) {
                // should we update curr1 or curr2?
                // pick the one that gets closer to target
                long curr1Diff = getDiff(curr1, curr1.left);
                long curr2Diff = getDiff(curr2, curr2.left);

                if (curr1Diff == 0 && curr1Diff == curr2Diff) {
                    // if stuck, exit while loop
                    break;
                }

                long c1Distance = Math.abs(target - (currSum + curr1Diff));
                long c2Distance = Math.abs(target - (currSum + curr2Diff));

                if (c1Distance <= c2Distance) {
                    // update curr1
                    curr1 = curr1.left;
                } else {
                    // update curr2
                    curr2 = curr2.left;
                }

            }
            // if sum too small, we want to add -> go right branch
            else if (currSum < target) {

                long curr1Diff = getDiff(curr1, curr1.right);
                long curr2Diff = getDiff(curr2, curr2.right);

                if (curr1Diff == 0 && curr1Diff == curr2Diff) {
                    // if stuck, exit while loop
                    break;
                }

                long c1Distance = Math.abs(target - (currSum + curr1Diff));
                long c2Distance = Math.abs(target - (currSum + curr2Diff));

                if (c1Distance <= c2Distance) {
                    // update curr1
                    curr1 = curr1.right;
                } else {
                    // update curr2
                    curr2 = curr2.right;
                }
            }
        }
        return false;
    }

    private long getDiff(TreeNode parent, TreeNode child) {
        if (parent == null || child == null) {
            return 0;
        } else {
            return child.val - parent.val;
        }
    }
}
