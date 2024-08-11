package com.coding.leetcode.amazon.sortingAndSearching.t252_meetingRooms;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{{7, 10}, {2, 4}};
        System.out.println(solution.canAttendMeetings(arr));
    }

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        for (int i = 0; i < intervals.length - 1; i++) {
            int n1 = intervals[i][1];
            int n2 = intervals[i + 1][0];
            if (n1 > n2) {
                return false;
            }
        }

        return true;
    }

}
