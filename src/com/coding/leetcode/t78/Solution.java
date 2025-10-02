package com.coding.leetcode.t78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3});

        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(0, nums, resList, cur);

        return resList;
    }

    private void backtrack(int start, int[] nums, List<List<Integer>> resList, List<Integer> cur) {
        resList.add(new ArrayList<>(cur));

        for (int i = start; i < nums.length; i++) {

            cur.add(nums[i]);
            backtrack(i + 1, nums, resList, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
