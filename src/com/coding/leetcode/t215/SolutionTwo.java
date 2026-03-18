package com.coding.leetcode.t215;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SolutionTwo {

    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num: nums) {
            list.add(num);
        }

        return quickSelect(list, k);
    }

    public int quickSelect(List<Integer> nums, int k) {
        int pivotIndex = new Random().nextInt(nums.size());
        int pivot = nums.get(pivotIndex);

        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num: nums) {
            if (num > pivot) {
                right.add(num);
            } else if (num < pivot) {
                left.add(num);
            } else {
                mid.add(num);
            }
        }

        if (k <= right.size()) {
            return quickSelect(right, k);
        }

        if (k > right.size() + mid.size()) {
            return quickSelect(left, k - right.size() - mid.size());
        }

        return pivot;
    }

}
