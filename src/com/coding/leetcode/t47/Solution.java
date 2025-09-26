package com.coding.leetcode.t47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtrack(nums, resList, cur, visited);

        return resList;
    }

    private void backtrack(int[] nums, List<List<Integer>> resList, List<Integer> cur, boolean[] visited) {
        if (cur.size() == nums.length) {
            resList.add(new ArrayList<>(cur));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]){
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            cur.add(nums[i]);

            backtrack(nums, resList, cur, visited);

            visited[i] = false;
            cur.remove(cur.size() - 1);
        }
    }

}
