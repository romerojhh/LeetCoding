package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null ) {
            return result;
        }
        TreeNode curr = root;
        q.offer(curr);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> aList = new LinkedList<>();
            for (int i = 0 ; i < size ; i++) {
                TreeNode currNode = q.poll();
                aList.add(currNode.val);

                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }
            result.add(aList);
        }

        return result;
    }
}
