package com.coding.leetcode.t103;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;


        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            boolean leftToRight = (level % 2 == 1);
            LinkedList<Integer> list = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();

                if (leftToRight) {
                    // left to right
                    list.addLast(treeNode.val);
                } else {
                    // right to left
                    list.addFirst(treeNode.val);
                }

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }

            resList.add(list);
        }

        return resList;
    }

}
