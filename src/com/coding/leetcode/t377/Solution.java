package com.coding.leetcode.t377;

public class Solution {

    // [left, right]
    // left with root
    //right without root

    public int rob(TreeNode root) {
        int[] dfs = dfs(root);
        return Math.max(dfs[0], dfs[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] leftArr = dfs(node.left);
        int[] rightArr = dfs(node.right);

        int valWithRoot = node.val + leftArr[1] + rightArr[1];

        int valWithoutRoot = Math.max(leftArr[0], leftArr[1]) + Math.max(rightArr[0], rightArr[1]);

        return new int[] {valWithRoot, valWithoutRoot};
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
