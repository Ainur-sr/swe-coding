package com.coding.leetcode;

public class Solution {

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
        ListNode resultNode = null;
        ListNode next = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int remainder = 0;

        while (true) {
            int res = 0;

            if (cur1 != null && cur2 != null) {
                int n1 = cur1.val;
                int n2 = cur2.val;
                int t = n1 + n2 + remainder;
                remainder = t / 10;
                res = t % 10;
            } else if (cur1 != null) {
                int n1 = cur1.val;
                int t = n1 + remainder;
                remainder = t / 10;
                res = t % 10;
            } else if (cur2 != null) {
                int n2 = cur2.val;
                int t = n2 + remainder;
                remainder = t / 10;
                res = t % 10;
            } else if (remainder > 0) {
                res = remainder;
                remainder = -1;
            } else {
                break;
            }

            if (resultNode == null) {
                resultNode = new ListNode(res);
            } else {
                ListNode cur = new ListNode(res);
                if (resultNode.next == null) {
                    resultNode.next = cur;
                    next = cur;
                } else {
                    next.next = cur;
                    next = cur;
                }

            }

            cur1 = cur1 != null ? cur1.next : null;
            cur2 = cur2 != null ? cur2.next : null;
        }

        return resultNode;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        if (next != null) {
            sb.append(",");
        }

        if (next != null) {
            sb.append(next.toString());
        }

        return sb.toString();
    }
}
