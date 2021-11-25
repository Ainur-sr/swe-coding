package com.coding.leetcode.t7;

public class SolutionOne {

    public static void main(String[] args) {
        System.out.println(reverse(-123)); //-321
        System.out.println(reverse(-2_147_483_412)); //-2143847412
        System.out.println(reverse(-2_147_483_648)); //0
    }

    public static int reverse(int x) {
        int[] intMin = {2, 1, 4, 7, 4, 8, 3, 6, 4, 8};
        int[] intMax = {2, 1, 4, 7, 4, 8, 3, 6, 4, 7};
        int[] resArr = new int[10];

        if (x < 10 && x > -10) return x;
        int d = x;
        int result = 0;
        int count = 0;

        while (d != 0) {
            int ost = d % 10;
            d = d / 10;
            if (count == 0) {
                result = ost;
            } else {
                result = (result * 10) + ost;
            }

            count++;

            if (count > 10) return 0;
            resArr[count - 1] = Math.abs(ost);
        }

        if (count == 10 && result == 0) {
            return 0;
        }

        if (count < 10) {
            return result;
        } else if (count == 10) {
            if (x > 0) {
                for (int i = 0; i < resArr.length; i++) {
                    if (resArr[i] > intMax[i]) {
                        return 0;
                    } else if (resArr[i] < intMax[i]) {
                        return result;
                    }
                }
            } else {
                for (int i = 0; i < resArr.length; i++) {
                    if (resArr[i] > intMin[i]) {
                        return 0;
                    } else if (resArr[i] < intMin[i]) {
                        return result;
                    }
                }
            }
        }
        return 0;
    }
}
