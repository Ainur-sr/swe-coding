package com.coding.leetcode.t98;

public class Solution {

    public static void main(String[] args) {
        boolean test03 = isValidBST(test03());
        System.out.println("test03 : " + test03);
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode node, long minVal, long maxVal) {
        if (node == null) return true;
        if (node.val <= minVal || node.val >= maxVal) return false;
        return isValidBST(node.left, minVal, node.val) && isValidBST(node.right, node.val, maxVal);
    }

    private static TreeNode test03() {
        TreeNode rootLeft_l1 = new TreeNode(50, new TreeNode(20), new TreeNode(55));
        TreeNode rootLeft_r1 = new TreeNode(100, new TreeNode(75), new TreeNode(110));
        TreeNode rootLeft = new TreeNode(70, rootLeft_l1, rootLeft_r1);

        TreeNode rootRight_l1 = new TreeNode(130, new TreeNode(119), new TreeNode(135));
        TreeNode rootRight_r1 = new TreeNode(160, new TreeNode(150), new TreeNode(200));
        TreeNode rootRight = new TreeNode(140, rootRight_l1, rootRight_r1);

        TreeNode root = new TreeNode(120, rootLeft, rootRight);
        return root;
    }
}
