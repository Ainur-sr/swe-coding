package com.coding.leetcode.t102;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();

        dfs(root, 0, resList);

        return resList;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> resList) {
        if (node == null) {
            return;
        }

        int lastIndexOfRes = resList.size() - 1;

        if (lastIndexOfRes < level) {
            ArrayList<Integer> ints = new ArrayList<>();
            ints.add(node.val);
            resList.add(ints);
        } else {
            resList.get(level).add(node.val);
        }

        dfs(node.left, level + 1, resList);
        dfs(node.right, level + 1, resList);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}