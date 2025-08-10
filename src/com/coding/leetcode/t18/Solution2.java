package com.coding.leetcode.t18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();

        for (int i1 = 0; i1 < nums.length - 3; i1++) {
            if (i1 > 0 && nums[i1] == nums[i1 - 1]) continue;

            for (int i2 = i1 + 1; i2 < nums.length - 2; i2++) {
                if (i2 > i1 + 1 && nums[i2] == nums[i2 - 1]) continue;
                int l = i2 + 1;
                int r = nums.length - 1;

                while (l < r) {
                    long sum = (long) nums[i1] + nums[i2] + nums[l] + nums[r];

                    if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        resList.add(List.of(nums[i1], nums[i2], nums[l], nums[r]));

                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1])
                            l++;
                        while (l < r && nums[r] == nums[r + 1])
                            r--;
                    }

                }
            }
        }

        return resList;
    }

}
