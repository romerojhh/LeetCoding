package main;

/*
    250. Count Univalue Subtrees

    Given the root of a binary tree, return the number of uni-value subtrees.

    A uni-value subtree means all nodes of the subtree have the same value.
 */
public class CountUnivalueSubstrees {
    public int countUnivalSubtrees(TreeNode root) {
        int[] counter = new int[1];
        if (root == null) {
            return 0;
        }
        bottomUp(root, counter, root.val);
        return counter[0];
    }

    private boolean bottomUp(TreeNode currNode, int[] counter, int parentVal) {

        if (currNode != null) {

            boolean left = bottomUp(currNode.left, counter, currNode.val);
            boolean right = bottomUp(currNode.right, counter, currNode.val);

            if (left && right) {
                counter[0]++;
            }

            if (currNode.val != parentVal || !(left && right)) {
                return false;
            } else {
                return true;
            }
        }

        return true;
    }

}
