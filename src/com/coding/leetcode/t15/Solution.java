package com.coding.leetcode.t15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4})); //[[-1,-1,2],[-1,0,1]]
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int n1 = nums[i];
                int n2 = nums[left];
                int n3 = nums[right];

                int sum = n1 + n2 + n3;

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    resList.add(List.of(n1, n2, n3));
                    left++;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                }
            }

        }

        return resList;
    }

}
