package com.coding.leetcode.t77;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);

        System.out.println(combine);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        backtrack(1, n, k, resList, cur);
        return resList;
    }

    private void backtrack(int start, int n, int k, List<List<Integer>> resList, List<Integer> cur) {
        if (cur.size() == k) {
            resList.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i <= n; i++) {
            cur.add(i);
            backtrack(i + 1, n, k, resList, cur);
            cur.removeLast();
        }
    }

}
