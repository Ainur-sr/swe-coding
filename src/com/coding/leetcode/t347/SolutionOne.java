package com.coding.leetcode.t347;

import java.util.*;
import java.util.stream.Stream;

public class SolutionOne {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};

        int[] result = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer freq = entry.getValue();
            if (!freqMap.containsKey(freq)) {
                freqMap.put(freq, new ArrayList<>());
            }
            freqMap.get(freq).add(key);
        }

        int[] res = new int[k];
        int ind = 0;
        while (ind < k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            List<Integer> list = entry.getValue();
            for (Integer integer : list) {
                if (ind < k){
                    res[ind] = integer;
                    ind++;
                } else{
                    break;
                }
            }
        }

        return  res;
    }

}
