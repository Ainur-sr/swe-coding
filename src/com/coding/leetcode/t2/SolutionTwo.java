package com.coding.leetcode.t2;

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

        ListNode result = new ListNode(0);
        ListNode cur = result;

        int surplus = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + surplus;
            surplus = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + surplus;
            surplus = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + surplus;
            surplus = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l2 = l2.next;
        }

        if (surplus != 0) {
            cur.next = new ListNode(surplus);
        }

        return result.next;
    }

}

