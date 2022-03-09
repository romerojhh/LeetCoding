package main;

/*
    116. Populating Next Right Pointers in Each Node

    You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
    The binary tree has the following definition:

    struct Node {
      int val;
      Node *left;
      Node *right;
      Node *next;
    }

    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

    Initially, all next pointers are set to NULL.
 */

//-------------- Note -------------------
// Depth-first-search -> where we explore the tree in one branch at a time i.e., pre-order, in-order, post-order traversals
// Breadth-first-search -> Exploring the "level" of the tree first before moving to the next level.
// We process all the nodes on one level before moving on to the next one.
// --------------------------------------

// Remember that BFS use Queue and DFS uses stack!

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingRightPointers {

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main (String[] args) {
        PopulatingRightPointers p = new PopulatingRightPointers();
        Node res = p.connect(new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, new Node(6), new Node(7), null), null));
    }

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        // The while loop here is for the exploring each level
        while (!queue.isEmpty()) {
            int nodesAmount = queue.size();

            // The for loop here is for exploring each node in each level
            // The amount of iteration is limited by the size of the queue so that we don't explore the nodes in the next level
            for (int i = 0 ; i < nodesAmount ; i++) {
                Node currNode = queue.poll();

                if (currNode != null) {

                    if (i != nodesAmount - 1) {
                        currNode.next = queue.peek();
                    } else {
                        currNode.next = null;
                    }

                    if (currNode.left != null) {
                        queue.add(currNode.left);
                    }

                    if (currNode.right != null) {
                        queue.add(currNode.right);
                    }
                }
            }
        }

        return root;
    }
}
