package main;

import java.util.HashMap;

/*
    106. Construct Binary Tree from Inorder and Postorder Traversal

    Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and
    postorder is the postorder traversal of the same tree, construct and return the binary tree.
 */

public class ConstructBinaryTreeInorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return new TreeNode();
        }
        // key -> node val, value -> idx in array
        HashMap<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0 ; i < inorder.length ; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(0, inorder.length - 1, postorder, inorderMap, new int[]{postorder.length - 1});
    }

    private TreeNode helper(int left, int right, int[] postorder, HashMap<Integer,Integer> inorderMap, int[] postIdx) {
        if (left > right || postIdx[0] < 0 || postIdx[0] >= postorder.length) {
            return null;
        }

        int rootVal = postorder[postIdx[0]];
        TreeNode res = new TreeNode(rootVal);

        int mid = inorderMap.get(rootVal);
        postIdx[0]--;

        res.right = helper(  + 1, right, postorder, inorderMap, postIdx);
        res.left = helper(left, mid - 1, postorder, inorderMap, postIdx);
        return res;
    }
}
