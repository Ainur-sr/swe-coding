package com.coding.leetcode.t133;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> cloneMap = new HashMap<>();

        return dfs(node, cloneMap);
    }

    private Node dfs(Node node, Map<Node, Node> cloneMap) {
        if (cloneMap.containsKey(node)) {
            return cloneMap.get(node);
        }

        Node cloneNode = new Node(node.val);

        cloneMap.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            Node curClone = dfs(neighbor, cloneMap);
            cloneNode.neighbors.add(curClone);
        }

        return cloneNode;
    }

}
