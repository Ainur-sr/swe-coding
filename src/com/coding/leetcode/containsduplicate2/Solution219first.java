package com.coding.leetcode.containsduplicate2;

import java.util.*;

public class Solution219first {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3)); //true
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 1)); //true
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2)); //false
        System.out.println(containsNearbyDuplicate(new int[]{1,2}, 2)); //false
        System.out.println(containsNearbyDuplicate(new int[]{0, 1, 2, 3, 4, 0, 0, 7, 8, 9, 10, 11, 12, 0}, 1)); //true
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2 || nums.length > 100_000 || k < 0 || k > 100_000) {
            return false;
        }
        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];

            if (indexMap.get(number) != null) {
                indexMap.get(number).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                indexMap.put(number, list);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : indexMap.entrySet()) {
            List<Integer> indexes = entry.getValue();
            if (indexes.size() < 2) {
                continue;
            }
            for (int i = 0; i < indexes.size() - 1; i++) {
                Integer n1 = indexes.get(i);
                Integer n2 = indexes.get(i + 1);
                int abs = Math.abs(n1 - n2);
                if (abs <= k) {
                    return true;
                }
            }
        }

        return false;
    }


}
