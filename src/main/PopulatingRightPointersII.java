package main;

/*
    117. Populating Next Right Pointers in Each Node II

    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
    Initially, all next pointers are set to NULL.
 */

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingRightPointersII {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Node prevNode = null;
            Node currNode = q.poll();

            if (currNode.left != null) {
                q.offer(currNode.left);
            }
            if (currNode.right != null) {
                q.offer(currNode.right);
            }

            if (size - 1 == 0) {
                currNode.next = null;
            } else {
                for (int i = 0; i < size - 1; i++) {
                    prevNode = currNode;
                    currNode = q.poll();

                    if (currNode != null) {
                        if (currNode.left != null) {
                            q.offer(currNode.left);
                        }
                        if (currNode.right != null) {
                            q.offer(currNode.right);
                        }
                    }

                    prevNode.next = currNode;
                }
            }

        }
        return root;
    }
}
