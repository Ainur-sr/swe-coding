package com.coding.leetcode.Meta.question_03;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean oneEditDistance = solution.isOneEditDistance("ab", "acb");
        System.out.println(oneEditDistance);
    }

    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (Math.abs(sLen - tLen) > 1) {
            return  false;
        }

        if (sLen > tLen) {
            return isOneEditDistance(t, s);
        }

        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sLen == tLen) {
                    // Замена
                   return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    // Вставка в s или удаление из t
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }

        return tLen - sLen == 1;
    }

}
