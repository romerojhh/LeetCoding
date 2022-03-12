package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryPreOrderTraversal {
    public static void main (String[] args) {
        TreeNode root = new TreeNode(7, new TreeNode(5, new TreeNode(4), new TreeNode(6)),
                new TreeNode(9, new TreeNode(8), new TreeNode(10)));
        BinaryPreOrderTraversal bp = new BinaryPreOrderTraversal();
        bp.preorderTraversal(root);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode currNode = root;

        while(currNode != null || !stack.empty()) {
            while (currNode != null) {
                stack.push(currNode);
                list.add(currNode.val);
                currNode = currNode.right;
            }
            currNode = stack.pop();
            currNode = currNode.left;
        }
        return list;
    }
}
