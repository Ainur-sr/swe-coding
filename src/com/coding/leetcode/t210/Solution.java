package com.coding.leetcode.t210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prerequisitesMap = new HashMap<>();
        Set<Integer> visitedCourses = new HashSet<>(); // For cycle detection
        Set<Integer> visitedOutput = new HashSet<>(); // For processed courses
        List<Integer> result = new ArrayList<>();

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            List<Integer> prerequisiteList = prerequisitesMap.get(course);

            if (prerequisiteList == null) {
                prerequisiteList = new ArrayList<>();
                prerequisitesMap.put(course, prerequisiteList);
                prerequisiteList.add(prereq);
            } else {
                prerequisiteList.add(prereq);
            }
        }

        for (int course = 0; course < numCourses; course++) {
            boolean dfsRes = dfs(course, prerequisitesMap, visitedCourses, visitedOutput, result);
            if (!dfsRes) {
                return new int[0];
            }
        }

        // Convert to array
        int[] resArr = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            resArr[i] = result.get(i);
        }
        return resArr;
    }

    private boolean dfs(int curCourse, Map<Integer, List<Integer>> prerequisitesMap,
                        Set<Integer> visitedCourses, Set<Integer> visitedOutput,
                        List<Integer> result) {

        if (visitedCourses.contains(curCourse)) {
            return false;  // Cycle detected
        }
        if (visitedOutput.contains(curCourse)) {
            return true;   // Already processed
        }

        visitedCourses.add(curCourse);

        List<Integer> prerequisiteList = prerequisitesMap.get(curCourse);
        if (prerequisiteList != null) {
            for (Integer prereqCourse : prerequisiteList) {
                boolean dfsRes = dfs(prereqCourse, prerequisitesMap, visitedCourses, visitedOutput, result);
                if (!dfsRes) {
                    return false;
                }
            }
        }

        // Add to result AFTER processing all prerequisites
        visitedCourses.remove(curCourse);
        visitedOutput.add(curCourse);
        result.add(curCourse);

        return true;
    }

}
