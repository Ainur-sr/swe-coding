package com.coding.leetcode.amazon.ArraysAndStrings.t1152_AnalyzeUserWebsite;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] username = new String[]{"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
        int[] timestamp = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] website = new String[]{"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};
//        List<String> res = sol.mostVisitedPattern(username, timestamp, website);
//        System.out.println(res);

        String[] username2 = new String[]{"ua", "ua", "ua", "ub", "ub", "ub"};
        int[] timestamp2 = new int[]{1, 2, 3, 4, 5, 6};
        String[] website2 = new String[]{"a", "b", "a", "a", "b", "c"};
//        List<String> res2 = sol.mostVisitedPattern(username2, timestamp2, website2);
//        System.out.println(res2);

        String[] username3 = new String[]{"zkiikgv", "zkiikgv", "zkiikgv", "zkiikgv"};
        int[] timestamp3 = new int[]{436363475, 710406388, 386655081, 797150921};
        String[] website3 = new String[]{"wnaaxbfhxp", "mryxsjc", "oz", "wlarkzzqht"};
//        List<String> res3 = sol.mostVisitedPattern(username3, timestamp3, website3);
//        System.out.println(res3);

        String[] username4 = new String[]{"h", "eiy", "cq", "h", "cq", "txldsscx", "cq", "txldsscx", "h", "cq", "cq"};
        int[] timestamp4 = new int[]{527896567, 334462937, 517687281, 134127993, 859112386, 159548699, 51100299, 444082139, 926837079, 317455832, 411747930};
        String[] website4 = new String[]{"hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "yljmntrclw", "hibympufi", "yljmntrclw"};
        List<String> res4 = sol.mostVisitedPattern(username4, timestamp4, website4);
        System.out.println(res4);
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, TreeMap<Integer, String>> map = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
                TreeMap<Integer, String> treeMap = map.computeIfAbsent(username[i], k -> new TreeMap<>());
            treeMap.put(timestamp[i], website[i]);
        }

        String maxPatern = "";
        Integer maxPatternScore = 0;
        Map<String, Set<String>> patternMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, TreeMap<Integer, String>> entry : map.entrySet()) {
            String user = entry.getKey();
            TreeMap<Integer, String> sitesMap = entry.getValue();

            if (sitesMap.size() == 3) {
                String p = String.join(":", sitesMap.values());

                Integer score = getScore(p, patternMap, user);
                Object[] calculateScore = calculateScore(p, score, maxPatern, maxPatternScore);
                maxPatern = (String) calculateScore[0];
                maxPatternScore = (Integer) calculateScore[1];
            } else if (sitesMap.size() > 3) {
                List<String> sites = sitesMap.values().stream().toList();

                for (int i1 = 0; i1 < sites.size() - 2; i1++) {
                    for (int i2 = i1 + 1; i2 < sites.size() - 1; i2++) {
                        for (int i3 = i2 + 1; i3 < sites.size(); i3++) {
                            sb.append(sites.get(i1)).append(":");
                            sb.append(sites.get(i2)).append(":");
                            sb.append(sites.get(i3));
                            String p = sb.toString();
                            sb.setLength(0);

                            Integer score = getScore(p, patternMap, user);
                            Object[] calculateScore = calculateScore(p, score, maxPatern, maxPatternScore);
                            maxPatern = (String) calculateScore[0];
                            maxPatternScore = (Integer) calculateScore[1];
                        }
                    }
                }
            }

        }

        return Arrays.stream(maxPatern.split(":")).collect(Collectors.toList());
    }

    private Integer getScore(String p, Map<String, Set<String>> patternMap, String user) {
        Set<String> users = patternMap.computeIfAbsent(p, k -> new HashSet<>());
        users.add(user);
        return users.size();
    }

    private Object[] calculateScore(String pattern, Integer score, String maxPattern, Integer maxPatternScore) {
        Object[] res = new Object[2];
        if (score > maxPatternScore) {
            res[0] = pattern;
            res[1] = score;
        } else if (score.equals(maxPatternScore)) {
            res[0] = maxPattern.compareTo(pattern) > 0 ? pattern : maxPattern;
            res[1] = score;
        } else {
            res[0] = maxPattern;
            res[1] = maxPatternScore;
        }
        return res;
    }

}
