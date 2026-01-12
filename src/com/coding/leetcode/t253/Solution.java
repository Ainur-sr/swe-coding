package com.coding.leetcode.t253;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //[0,30],[5,10],[15,20]
        int[][] meetings = new int[][]{{0, 30}, {5, 10}, {15, 20}};

        System.out.println(solution.minMeetingRooms(meetings));

    }

    public int minMeetingRooms(int[][] intervals) {
        int count = 0;
        int max = Integer.MIN_VALUE;

        int[] startArr = new int[intervals.length];
        int[] endArr = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startArr[i] = intervals[i][0];
            endArr[i] = intervals[i][1];
        }
        Arrays.sort(startArr);
        Arrays.sort(endArr);

        int startPoint = 0;
        int endPoint = 0;

        while (startPoint < startArr.length) {
            if (startArr[startPoint] < endArr[endPoint]) {
                startPoint++;
                count++;
            } else{
                endPoint++;
                count--;
            }
            max = Math.max(max, count);
        }

        return max;
    }

}
