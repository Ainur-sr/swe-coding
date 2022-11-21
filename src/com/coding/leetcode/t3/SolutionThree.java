package com.coding.leetcode.t3;

import java.util.HashMap;
import java.util.Map;

public class SolutionThree {

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring2("dvdf"));
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
    }

    public static int lengthOfLongestSubstring3(String s) {
        int max = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int startFrom = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character ch = chars[i];
            if (charMap.containsKey(ch)) {
                startFrom = Math.max(startFrom, charMap.get(ch) + 1);
            }
            charMap.put(ch, i);
            max = Math.max(max, i - startFrom + 1);
        }

        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        String maxStr = "";

        if (s.length() > 0) {
            max = 1;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            String curStr = "";

            for (int j = i + 1; j < s.length(); j++) {
                String iStr = s.substring(i, i + 1);
                String jStr = s.substring(j, j + 1);
                if (iStr.equals(jStr) || curStr.contains(jStr)) {
                    break;
                }
                curStr = s.substring(i, j + 1);

                if (curStr.length() > max) {
                    max = curStr.length();
                    maxStr = curStr;
                }
            }
        }

        System.out.println(maxStr);
        return max;
    }

    //O(N)time O(N)space
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            Character ch = s.charAt(i);
            if (map.containsKey(ch)) {
                j = Math.max(j, map.get(ch) + 1);
            }
            map.put(ch, i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

}
