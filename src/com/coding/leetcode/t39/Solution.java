package com.coding.leetcode.t39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        backtrack(0, candidates, target, target, resList, cur);
        return resList;
    }

    private void backtrack(int start, int[] candidates, int target, int rem, List<List<Integer>> resList, List<Integer> cur) {
        if (rem == 0) {
            resList.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (rem < candidates[i]) {
                return;
            }

            int newRem = rem - candidates[i];

            cur.add(candidates[i]);
            backtrack(i, candidates, target, newRem, resList, cur);
            cur.remove(cur.size() - 1);
        }
    }

}
