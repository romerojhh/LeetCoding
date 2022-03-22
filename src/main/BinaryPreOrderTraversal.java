package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryPreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        // Go to the leftmost leaf first
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        stack.push(root);
        list.add(root.val);
        TreeNode currNode = root.left;

        while (!stack.empty()) {
            while (currNode != null) {
                stack.push(currNode);
                list.add(currNode.val);
                currNode = currNode.left;
            }
            // we reach the leftMostNode here!
            TreeNode leftMost = stack.pop();

            currNode = stack.peek().right;
        }

        return list;
    }
}
