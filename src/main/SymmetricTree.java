package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
    101. Symmetric Tree

    Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(5), new TreeNode(6)),
                new TreeNode(4, new TreeNode(7), new TreeNode(8))),
                new TreeNode(2, new TreeNode(4, new TreeNode(8), new TreeNode(7)),
                        new TreeNode(3, new TreeNode(6), new TreeNode(5))));
        SymmetricTree s = new SymmetricTree();
        System.out.println(s.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && isMirror(root1.right,root2.left) && isMirror(root1.left, root2.right);
    }
}
