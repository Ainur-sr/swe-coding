package com.coding.leetcode.t937;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        String[] input1 = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] output1 = new String[]{"let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"};

        String[] input2 = new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        String[] output2 = new String[]{"g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"};

        Solution solution = new Solution();
        String[] res1 = solution.reorderLogFiles(input1);
        String[] res2 = solution.reorderLogFiles(input2);

        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));

        System.out.println(Arrays.equals(res1, output1));
        System.out.println(Arrays.equals(res2, output2));
    }


    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            boolean isLog1Letter = Character.isLetter(log1.charAt(log1.length() - 1));
            boolean isLog2Letter = Character.isLetter(log2.charAt(log2.length() - 1));

            if (isLog1Letter && !isLog2Letter) return -1;

            if (!isLog1Letter && isLog2Letter) return 1;

             if (isLog1Letter && isLog2Letter) {
                int id1Size = log1.indexOf(" ");
                int id2Size = log2.indexOf(" ");

                String content1 = log1.substring(id1Size + 1);
                String content2 = log2.substring(id2Size + 1);

                if (content1.equals(content2)) {
                    return log1.substring(0, id1Size).compareTo(log2.substring(0, id2Size));
                }

                return content1.compareTo(content2);
            }
            return 0;
        });

        return logs;
    }

}
