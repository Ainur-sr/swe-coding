package com.coding.leetcode.t40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(0, target, candidates, target, resList, cur);
        return resList;
    }

    private void backtrack(int start, int rem, int[] candidates, int target, List<List<Integer>> resList, List<Integer> cur) {
        if (rem == 0) {
            resList.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (rem < candidates[i]) {
                return;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            int newRem = rem - candidates[i];

            cur.add(candidates[i]);
            backtrack(i + 1, newRem, candidates, target, resList, cur);
            cur.remove(cur.size() - 1);
        }
    }

}
