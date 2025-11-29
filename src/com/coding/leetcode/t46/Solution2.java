package com.coding.leetcode.t46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resLists = new ArrayList<>();

        backtrack(nums, 0, resLists);

        return resLists;
    }


    private void backtrack(int[] nums, int start, List<List<Integer>> resLists) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            resLists.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            backtrack(nums, start + 1, resLists);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
