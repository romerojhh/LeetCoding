package main;

/*
    112. Path Sum

    Given the root of a binary tree and an integer targetSum,
    return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

    A leaf is a node with no children.
 */
public class PathSum {
    public static void main (String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return topDown(root, 0, targetSum);
    }

    private boolean topDown(TreeNode currNode, int currSum, int target) {
        if (currNode != null) {
            if (currNode.right == null) {
                return topDown(currNode.left, currNode.val + currSum, target);
            } else if (currNode.left == null) {
                return topDown(currNode.right, currNode.val + currSum, target);
            }
            return topDown(currNode.left, currNode.val + currSum, target) ||
                    topDown(currNode.right, currNode.val + currSum, target);
        }
        return target == currSum;
    }
}
