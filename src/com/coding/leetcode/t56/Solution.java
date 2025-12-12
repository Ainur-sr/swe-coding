package com.coding.leetcode.t56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] arr1, int[] arr2) -> arr1[0] - arr2[0]);
        List<int[]> resList = new ArrayList<>();
        resList.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastArr = resList.getLast();
            int[] curArr = intervals[i];

            if (lastArr[1] >= curArr[0]) { // merge
                lastArr[1] = Math.max(lastArr[1], curArr[1]);
            } else {
                resList.add(curArr);
            }
        }

        int[][] resArray = new int[resList.size()][];
        for (int i = 0; i < resList.size(); i++) {
            resArray[i] = resList.get(i);
        }
        return resArray;
    }

}
