package com.coding.leetcode.amazon.design.t297_SerializeDeserializeBinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(sb, root);
        return sb.toString();
    }

    private void serializeHelper(StringBuilder sb, TreeNode treeNode){
        if (treeNode == null) {
            sb.append("null");
            return;
        }

        sb.append(treeNode.val).append(",");
        serializeHelper(sb, treeNode.left);
        sb.append(",");
        serializeHelper(sb, treeNode.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String str = queue.poll();
        if (str == null || str.equals("null")) return null;

        TreeNode treeNode = new TreeNode(Integer.parseInt(str));
        treeNode.left = deserializeHelper(queue);
        treeNode.right = deserializeHelper(queue);

        return treeNode;
    }

}
