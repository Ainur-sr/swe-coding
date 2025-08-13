package com.coding.leetcode.t347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionTwo {

    public int[] topKFrequentBucket(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.put(x, freq.getOrDefault(x, 0) + 1);

        // buckets[i] = список чисел с частотой i
        List<Integer>[] buckets = new List[nums.length + 1];
        for (var e : freq.entrySet()) {
            int f = e.getValue();
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(e.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int f = buckets.length - 1; f >= 0; f--) {
            if (idx >= k) break;
            if (buckets[f] == null) continue;

            for (int val : buckets[f]) {
                res[idx++] = val;
                if (idx == k) break;
            }
        }
        return res;
    }


}
