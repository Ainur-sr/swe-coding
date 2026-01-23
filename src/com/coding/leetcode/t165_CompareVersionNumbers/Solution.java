package com.coding.leetcode.t165_CompareVersionNumbers;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.compareVersion("7.5.2.4", "7.5.3");
        System.out.println(i);
    }

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        for (int i = 0; i < Math.max(arr1.length, arr2.length); i++) {
            int n1 = 0;
            if (i < arr1.length) n1 = Integer.parseInt(arr1[i]);

            int n2 = 0;
            if (i < arr2.length) n2 = Integer.parseInt(arr2[i]);

            if (n1 > n2) return 1;
            else if (n1 < n2) return -1;
        }
        return 0;
    }

}
