package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    133. Clone Graph

    Given a reference of a node in a connected undirected graph.

    Return a deep copy (clone) of the graph.

    Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */
public class CloneGraph {

    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return node;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node res = new Node(node.val, new ArrayList());
        visited.put(node, res);

        for (Node neighborNode : node.neighbors) {
            res.neighbors.add(cloneGraph(neighborNode));
        }

        return res;
    }
}
