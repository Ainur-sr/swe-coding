package com.coding.leetcode.t47;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionTwo {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        dfs(nums, map, resList, curList);
        return resList;
    }

    private void dfs(int[] nums, Map<Integer, Integer> map, List<List<Integer>> resList, List<Integer> curList) {
        if (nums.length == curList.size()) {
            resList.add(new ArrayList<>(curList));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0){
                continue;
            }
            curList.add(entry.getKey());
            map.put(entry.getKey(), entry.getValue() - 1);

            dfs(nums, map, resList, curList);

            curList.remove(curList.size() - 1);
            map.put(entry.getKey(), entry.getValue() + 1);
        }
    }

}
