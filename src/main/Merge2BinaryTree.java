package main;

/*
    617. Merge Two Binary Trees

    You are given two binary trees root1 and root2.

    Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
    You need to merge the two trees into a new binary tree.
    The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
    Otherwise, the NOT null node will be used as the node of the new tree.

    Return the merged tree.

    Note: The merging process must start from the root nodes of both trees.
 */
public class Merge2BinaryTree {
    public static void main (String[] args) {
        Merge2BinaryTree m = new Merge2BinaryTree();
        TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode res = m.mergeTrees(root1, root2);
        System.out.println("j");
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // basically when both nodes in both tree are not null -> sum them up
        // if one of the nodes is null, insert the nodes to the tree.
        // choose to manipulate data on root1
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    /*
    private void inOrder (TreeNode root1, TreeNode root2, TreeNode result, boolean left, boolean right) {
        // Let's traverse on root1!
        if (root1 != null && root2 != null) {

            // computation here?
            if (left) {
                result.left = new TreeNode(root1.val + root2.val);
            } else if (right) {
                result.right = new TreeNode(root1.val + root2.val);
            }

            inOrder(root1.left, root2.left, result.left, true, false);
            inOrder(root1.right, root2.right, result.right, false, true);
        } else if (root1 != null) {
            // means that root 2 is null
            if (left) {
                result.left = new TreeNode(root1.val);
            } else if (right) {
                result.right = new TreeNode(root1.val);
            }

            inOrder(root1.left, null, result.left, true, false);
            inOrder(root1.right, null, result.right, false, true);
        } else if (root2 != null) {
            // means that root 1 is null
            if (left) {
                result.left = new TreeNode(root1.val);
            } else if (right) {
                result.right = new TreeNode(root1.val);
            }

            inOrder(null, root2.left, result.left, true, false);
            inOrder(null, root2.right, result.right, false, true);
        } else {
            // If both null then we can't do anything else
            return;
        }

        /*
        if (root1 == null && root2 == null) {
            return;
        } else if (root1 == null) {
            result.val = root2.val;
        } else if (root2 == null) {
            result.val = root1.val;
        } else {
            result.val = root1.val + root2.val;
        }


    }
    */
}
