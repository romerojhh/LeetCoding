package main;

/*
    104. Maximum Depth of Binary Tree
    Given the root of a binary tree, return its maximum depth.

    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return topDown(root, 0);
    }

    private int topDown(TreeNode currNode, int depth) {
        if (currNode != null) {
            return Math.max(topDown(currNode.left, depth + 1), topDown(currNode.right, depth + 1));
        } else {
            return depth + 1;
        }
    }
}
