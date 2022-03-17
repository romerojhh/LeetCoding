package main;

import java.util.HashMap;

/*
    105. Construct Binary Tree from Preorder and Inorder Traversal

    Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
    and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
public class ConstructBinaryTreeInorderPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderIdx = new HashMap<>();
        for (int i = 0 ; i < inorder.length ; i++) {
            inorderIdx.put(inorder[i], i);
        }
        int[] preorderCounter = new int[]{0};

        return helper(0, preorder.length - 1, preorder, inorderIdx, preorderCounter);
    }

    private TreeNode helper(int leftBound, int rightBound, int[] preorder, HashMap<Integer,Integer> inorderIdx, int[] preorderCounter) {
        if (rightBound < leftBound || preorderCounter[0] >= preorder.length || preorderCounter[0] < 0) {
            return null;
        }

        int rootVal = preorder[preorderCounter[0]++];
        TreeNode root = new TreeNode(rootVal);
        int mid = inorderIdx.get(rootVal);

        root.left = helper(leftBound, mid - 1, preorder, inorderIdx, preorderCounter);
        root.right = helper(mid + 1, rightBound, preorder, inorderIdx, preorderCounter);

        return root;
    }
}
