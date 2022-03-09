package main;

import java.util.ArrayList;
import java.util.List;

/*
    1490. Clone N-ary Tree

    Each node in the n-ary tree contains a val (int) and a list (List[Node]) of its children.

    class Node {
        public int val;
        public List<Node> children;
    }

    Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 */

public class CloneNaryTree {

    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String[] args) {

    }

    public Node cloneTree(Node root) {
        Node res = new Node();

        if (root == null) {
            return null;
        } else {
            res.val = root.val;
            for (Node childNode : root.children) {
                res.children.add(cloneTree(childNode));
            }
        }

        return res;
    }
}
