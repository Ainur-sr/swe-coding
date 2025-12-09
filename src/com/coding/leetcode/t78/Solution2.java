package com.coding.leetcode.t78;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        dfs(0, nums, cur, resList);
        return resList;
    }

    private void dfs(int start, int[] nums, List<Integer> cur, List<List<Integer>> resList) {
        if (start == nums.length) {
            resList.add(new ArrayList<>(cur));
            return;
        }

        //include i
        cur.add(nums[start]);
        dfs(start + 1, nums, cur, resList);
        cur.removeLast();

        //not include i
        dfs(start + 1, nums, cur, resList);
    }

}
