package com.coding.leetcode.t46;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, resList, curList);
        return resList;
    }

    private void backtrack(int[] nums, boolean[] visited, List<List<Integer>> resList, List<Integer> curList) {
        if (curList.size() == nums.length) {
            resList.add(new ArrayList<>(curList));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            curList.add(nums[i]);
            visited[i] = true;

            backtrack(nums, visited, resList, curList);

            curList.remove(curList.size() - 1);
            visited[i] = false;
        }
    }

}
