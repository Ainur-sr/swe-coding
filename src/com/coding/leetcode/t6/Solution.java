package com.coding.leetcode.t6;

public class Solution {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4)); // PINALSIGYAHRPI
        System.out.println(convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
        System.out.println("**************");
        System.out.println(convert("AB", 1)); // AB
    }

    public static String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) return s;
        StringBuilder[] sbArr = new StringBuilder[numRows];
        for (int i = 0; i < sbArr.length; i++) {
            sbArr[i] = new StringBuilder();
        }

        numRows--;
        int y = 0;
        boolean isUp = false;

        for (int i = 0; i < s.length(); i++) {
            if (isUp == false && y <= numRows) {
                sbArr[y].append(s.charAt(i));
                y++;
            } else if (isUp == true) {
                sbArr[y].append(s.charAt(i));
                y--;
            }

            if (y > numRows) {
                isUp = true;
                y = y - 2;
            } else if (y < 0) {
                y = y + 2;
                isUp = false;
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sbArr.length; i++) {
            result.append(sbArr[i].toString());
        }

        return result.toString();
    }

}
