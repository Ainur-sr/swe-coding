package com.coding.leetcode.t215;

import java.util.Arrays;
import java.util.TreeSet;

public class SolutionOne {

    public static void main(String[] args) {

    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[k - 1];
    }


}
