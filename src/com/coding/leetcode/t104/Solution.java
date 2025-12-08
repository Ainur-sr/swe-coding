package com.coding.leetcode.t104;

public class Solution {

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int curDepth) {
        if (node == null) {
            return curDepth;
        }

        int leftDepth = dfs(node.left, curDepth + 1);
        int rightDepth = dfs(node.right, curDepth + 1);

        return Math.max(leftDepth, rightDepth);
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
