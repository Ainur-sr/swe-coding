package com.coding.leetcode.t90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        backtrack(0, nums, resList, cur);
        return resList;
    }

    private void backtrack(int start, int[] nums, List<List<Integer>> resList, List<Integer> cur) {
        resList.add(new ArrayList<>(cur));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            cur.add(nums[i]);
            backtrack(i + 1, nums, resList, cur);
            cur.remove(cur.size() - 1);
        }
    }

}
