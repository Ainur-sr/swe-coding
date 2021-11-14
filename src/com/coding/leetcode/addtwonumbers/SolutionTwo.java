package com.coding.leetcode.addtwonumbers;

public class SolutionTwo {

    public static void main(String[] args) {
        ListNode listNode1 = create(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode listNode2 = create(new int[]{9, 9, 9, 9});

        System.out.println(addTwoNumbers(listNode1, listNode2));
    }

    public static ListNode create(int[] arr) {
        ListNode listNode = null;
        ListNode next = null;

        for (int i : arr) {
            if (listNode == null) {
                listNode = new ListNode(i);
            } else {
                ListNode cur = new ListNode(i);
                if (listNode.next == null) {
                    listNode.next = cur;
                    next = cur;
                } else {
                    next.next = cur;
                    next = cur;
                }
            }
        }

        return listNode;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode next = null;
        int remainder = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + remainder;
            remainder = sum / 10;
            ListNode node = new ListNode(sum % 10);

            if (result == null) {
                result = node;
                next = node;
            } else {
                if (result.next == null) {
                    result.next = node;
                    next = node;
                } else {
                    next.next = node;
                    next = node;
                }
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (remainder > 0) {
            next.next = new ListNode(remainder);
        }

        return result;
    }

}

