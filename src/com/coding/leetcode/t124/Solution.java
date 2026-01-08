package com.coding.leetcode.t124;

import java.util.Map;

public class Solution {

    public int maxPathSum(TreeNode root) {
        int[] res = new int[] {root.val};

        dfs(res, root);

        return res[0];
    }

    // return max path sum without split
    private int dfs(int[] res, TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = dfs(res, root.left);
        int rightMax = dfs(res, root.right);

        //if value negative, then put '0'
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        // compute max path sum with split
        int splitSum = root.val + leftMax + rightMax;
        res[0] = Math.max(res[0], splitSum);

        // return max path sum without split
        return root.val + Math.max(leftMax, rightMax);
    }

}
