package com.coding.leetcode.t22;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(n, 0, 0, resList, sb);
        return resList;
    }


    private void backtrack(int n, int open, int close, List<String> resList, StringBuilder sb) {
        if (sb.length() == n * 2) {
            resList.add(sb.toString());
        }

        if (open < n) {
            sb.append('(');
            backtrack(n, open + 1, close, resList, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            backtrack(n, open, close + 1, resList, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
