package com.coding.leetcode.t1;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); //[0,1]
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6))); //[1,2]
        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6))); //[0,1]
        System.out.println(Arrays.toString(twoSum(new int[]{-3,4,3,90}, 0))); //[0,2]
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        f:
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target){
                    result[0] = i;
                    result[1] = j;
                    break f;
                }
            }
        }

        return result;
    }

}
