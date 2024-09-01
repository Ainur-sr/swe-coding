package com.coding.leetcode.amazon.ArraysAndStrings.t165_CompareVersionNumbers;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.compareVersion("1.2", "1.10")); // -1
//        System.out.println(s.compareVersion("1.0", "1.0.0.0")); // -1
        System.out.println(s.compareVersion("1.01", "1.001")); // -1
    }

    public int compareVersion(String version1, String version2) {
        int v1Idx = 0;
        int v2Idx = 0;
        StringBuilder sb = new StringBuilder();
        while (v1Idx <= version1.length() || v2Idx <= version2.length()) {
            int b1 = 0;
            int b2 = 0;

            while (v1Idx <= version1.length()) {
                if (v1Idx == version1.length() || version1.charAt(v1Idx) == '.') {
                    b1 = Integer.parseInt(sb.toString());
                    sb.setLength(0);
                    v1Idx++;
                    break;
                }
                sb.append(version1.charAt(v1Idx));
                v1Idx++;
            }

            while (v2Idx <= version2.length()) {
                if (v2Idx == version2.length() || version2.charAt(v2Idx) == '.') {
                    b2 = Integer.parseInt(sb.toString());
                    sb.setLength(0);
                    v2Idx++;
                    break;
                }
                sb.append(version2.charAt(v2Idx));
                v2Idx++;
            }

            if (b1 == b2) continue;
            if (b1 > b2) return 1;
            else return -1;
        }
        return 0;
    }

}
