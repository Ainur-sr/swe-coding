package com.coding.leetcode.t98;

public class Solution {

    public static void main(String[] args) {
        boolean test01 = isValidBST(test01());
        boolean test02 = isValidBST(test02());
        boolean test03 = isValidBST(test03());
//        System.out.println("test01 : " + test01);
//        System.out.println("test02 : " + test02);
        System.out.println("test03 : " + test03);
    }

    public static boolean isValidBST(TreeNode root) {
        if (root.left != null && root.left.val >= root.val) return false;
        if (root.right != null && root.right.val <= root.val) return false;

        boolean result = checkTree(root.left, root.val, true) && checkTree(root.right, root.val, false);
        return result;
    }

    private static boolean checkTree(TreeNode node, int parentVal, boolean isLeft) {
        if (node == null) return true;

        boolean nodeLeftRes = true;
        boolean nodeRightRes = true;

        if (node.left != null) {
            if (isLeft) {
                if (!(node.left.val < parentVal && node.left.val < node.val)) return false;
            } else {
                if (!(node.left.val > parentVal && node.left.val < node.val)) return false;
            }
            nodeLeftRes = checkTree(node.left, node.val, true);
        }
        if (node.right != null) {
            if (isLeft) {
                if (!(node.right.val < parentVal && node.right.val < node.val)) return false;
            } else {
                if (!(node.right.val > parentVal && node.right.val > node.val)) return false;
            }
            nodeRightRes = checkTree(node.right, node.val, false);
        }

        return nodeLeftRes && nodeRightRes;
    }


    private static TreeNode test01() {
        TreeNode r1_l1 = new TreeNode(3);
        TreeNode r1_r1 = new TreeNode(6);

        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(4, r1_l1, r1_r1);

        TreeNode root = new TreeNode(5, l1, r1);
        return root;
    }

    private static TreeNode test02() {
        TreeNode r1_l1 = new TreeNode(3);
        TreeNode r1_r1 = new TreeNode(7);

        TreeNode l1 = new TreeNode(4);
        TreeNode r1 = new TreeNode(6, r1_l1, r1_r1);

        TreeNode root = new TreeNode(5, l1, r1);
        return root;
    }

    private static TreeNode test03() {
        TreeNode l1_l1 = new TreeNode(0);
        TreeNode l1_r1 = new TreeNode(2);

        TreeNode r1_l1 = new TreeNode(4);
        TreeNode r1_r1 = new TreeNode(6);

        TreeNode l1 = new TreeNode(1, l1_l1, l1_r1);
        TreeNode r1 = new TreeNode(5, r1_l1, r1_r1);

        TreeNode root = new TreeNode(3, l1, r1);
        return root;
    }
}
