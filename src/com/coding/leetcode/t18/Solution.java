package com.coding.leetcode.t18;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        List<List<Integer>> res1 = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
//        System.out.println(res1); //[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

        List<List<Integer>> res2 = solution.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
        System.out.println(res2); //[]
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(nums);

        kSum(4, 0, target, nums, resList, new LinkedList<>());

        return resList;
    }


    private void kSum(int k, int start, long target, int[] nums, List<List<Integer>> resList, LinkedList<Integer> list) {
        if (k != 2) {
            for (int i = start; i < nums.length - k + 1; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                list.add(nums[i]);
                kSum(k - 1, i + 1, target - nums[i], nums, resList, list);
                list.removeLast();
            }
            return;
        }

        // base case, two sum II
        int left = start;
        int right = nums.length - 1;

        while (left < right) {
            long sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                List<Integer> resNums = new ArrayList<>(list);
                resNums.add(nums[left]);
                resNums.add(nums[right]);
                resList.add(resNums);

                left++;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            }

        }

    }

}
