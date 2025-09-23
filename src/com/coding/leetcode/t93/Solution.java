package com.coding.leetcode.t93;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.restoreIpAddresses("25525511135").forEach(System.out::println);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> resList = new ArrayList<>();
        backtrack(s, 0, resList, new ArrayList<>());

        return resList;
    }

    private void backtrack(String s, int start, List<String> resList, List<String> cur) {
        if (cur.size() == 4) {
            if (start == s.length()) {
                resList.add(String.join(".", cur));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            int end = start + len;
            if (end > s.length()) {
                break;
            }

            String segment = s.substring(start, end);

            if (isValid(segment)) {
                cur.add(segment);
                backtrack(s, end, resList, cur);
                cur.remove(cur.size() - 1);
            }
        }


    }

    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }
        Integer num = Integer.parseInt(segment);

        return num >= 0 && num <= 255;
    }

}
