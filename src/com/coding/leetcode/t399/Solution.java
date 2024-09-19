package com.coding.leetcode.t399;

import java.util.*;

public class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            Set<String> visited = new HashSet<>();
            List<String> query = queries.get(i);
            if (query.get(0).equals(query.get(1))){
                if (graph.containsKey(query.get(0))){
                    ans[i] = 1.0;
                } else {
                    ans[i] = -1;
                }
                continue;
            }
            ans[i] = dfs(query.get(0), query.get(1), graph, visited);
        }

        return ans;
    }

    private double dfs(String start, String end,  Map<String, Map<String, Double>> graph, Set<String> visited) {
        if(!graph.containsKey(start)) {
            return -1.0;
        }

        if(graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);
        Map<String, Double> startMap = graph.get(start);

        for(Map.Entry<String, Double> entry: startMap.entrySet()) {
            if(!visited.contains(entry.getKey())){

                double currVal = dfs(entry.getKey(), end, graph, visited);

                if(currVal!=-1){
                    return currVal * entry.getValue();
                }
            }
        }

        return -1.0;

    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String startEl = equations.get(i).get(0);
            String endEl = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(startEl, new HashMap<>());
            graph.get(startEl).put(endEl, val);

            graph.putIfAbsent(endEl, new HashMap<>());
            graph.get(endEl).put(endEl, 1 / val);
        }
        return graph;
    }


}
