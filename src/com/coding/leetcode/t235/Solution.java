package com.coding.leetcode.t235;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curNode = root;

        while (curNode != null) {
            if (p.val > curNode.val && q.val > curNode.val) {
                curNode = curNode.right;
            } else if (p.val < curNode.val && q.val < curNode.val) {
                curNode = curNode.left;
            } else {
                return curNode;
            }
        }

        return null;
    }

}
