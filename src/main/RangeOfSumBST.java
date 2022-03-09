package main;

/*
    938. Range Sum of BST

    Given the root node of a binary search tree and two integers low and high,
    return the sum of values of all nodes with a value in the inclusive range [low, high].
 */
public class RangeOfSumBST {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return inOrder(root, low, high);
    }

    private int inOrder(TreeNode root, int low, int high) {
        int sum = 0;
        if (root != null) {
            // recurse left
            int currVal = root.val;
            sum += inOrder(root.left, low, high);
            if (currVal <= high && currVal >= low) {
                sum += currVal;
            }
            sum += inOrder(root.right, low, high);

        }

        return sum;
    }
}
