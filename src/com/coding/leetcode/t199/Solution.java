package com.coding.leetcode.t199;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resList = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            TreeNode maxRightNode = null;

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (node != null) {
                    maxRightNode = node;
                    deque.offerLast(node.left);
                    deque.offerLast(node.right);
                }
            }
            if (maxRightNode != null) {
                resList.add(maxRightNode.val);
            }
        }

        return resList;
    }

}
