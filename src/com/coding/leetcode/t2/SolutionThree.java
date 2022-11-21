package com.coding.leetcode.t2;

import java.util.ArrayList;
import java.util.List;

public class SolutionThree {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;

        System.out.println(addTwoNumbers(l1, n1));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        int surplus = 0;
        ListNode n = l1;
        ListNode b = l2;

        while (n != null && b != null) {
            int sum = n.val + b.val + surplus;
            surplus = 0;
            if (sum < 10) {
                list.add(sum);
            } else {
                list.add(sum % 10);
                surplus = sum / 10;
            }
            n = n.next;
            b = b.next;
        }

        while (n != null) {
            int sum = n.val + surplus;
            surplus = 0;
            if (sum < 10) {
                list.add(sum);
            } else {
                list.add(sum % 10);
                surplus = sum / 10;
            }
            n = n.next;
        }

        while (b != null) {
            int sum = b.val + surplus;
            surplus = 0;
            if (sum < 10) {
                list.add(sum);
            } else {
                list.add(sum % 10);
                surplus = sum / 10;
            }
            b = b.next;
        }

        if (surplus != 0) {
            list.add(surplus);
        }

        ListNode result = new ListNode(list.get(0));
        ListNode next = result;

        for (int i = 1; i < list.size(); i++) {
            next.next = new ListNode(list.get(i));
            next = next.next;
        }

        return result;
    }
}
