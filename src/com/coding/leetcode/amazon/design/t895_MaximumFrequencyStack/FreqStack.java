package com.coding.leetcode.amazon.design.t895_MaximumFrequencyStack;

import java.util.*;

public class FreqStack {

    private final Map<Integer, Integer> countMap;
    private final Map<Integer, Stack<Integer>> stackMap;
    private int countMax = 0;

    public FreqStack() {
        this.countMap = new HashMap<>();
        this.stackMap = new HashMap<>();
    }

    public void push(int val) {
        countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        Integer valCnt = countMap.get(val);

        if (valCnt > countMax) {
            countMax = valCnt;
            stackMap.putIfAbsent(valCnt, new Stack<>());
        }

        stackMap.get(valCnt).add(val);
    }

    public int pop() {
        Integer res = stackMap.get(countMax).pop();
        countMap.put(res, countMap.get(res) - 1);

        if (stackMap.get(countMax).isEmpty()){
            countMax = countMax - 1;
        }

        return res;
    }

}
