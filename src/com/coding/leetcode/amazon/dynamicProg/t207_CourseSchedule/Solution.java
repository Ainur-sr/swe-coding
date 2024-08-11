package com.coding.leetcode.amazon.dynamicProg.t207_CourseSchedule;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.canFinish(2, new int[][]{{0, 1}}));
    }

    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map.clear();
        visited.clear();

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            List<Integer> prereqList = map.get(course);
            if (prereqList == null) {
                List<Integer> list = new ArrayList<>();
                list.add(pre);
                map.put(course, list);
            } else {
                prereqList.add(pre);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }
        return true;
    }

    private boolean dfs(int course) {
        if (visited.contains(course)) return false;

        List<Integer> list = map.get(course);
        if (list == null || list.isEmpty()) {
            return true;
        }

        visited.add(course);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int pre = iterator.next();
            iterator.remove();
            boolean dfsRes = dfs(pre);
            if (!dfsRes) return false;
        }

        visited.remove(course);
        return true;
    }

}
