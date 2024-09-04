package com.coding.leetcode.amazon.linkedList.t21_MergeTwoSortedLists;

public class Solution {

    public static void main(String[] args) {

    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;

        ListNode head = new ListNode();
        ListNode cur = head;
        boolean toDo = true;

        while (toDo) {
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    cur.val = list1.val;
                    list1 = list1.next;
                } else {
                    cur.val = list2.val;
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                cur.val = list1.val;
                list1 = list1.next;
            } else if (list2 != null) {
                cur.val = list2.val;
                list2 = list2.next;
            }

            if (list1 != null || list2 != null) {
                cur.next = new ListNode();
                cur = cur.next;
            } else {
                toDo = false;
            }
        }

        return head;
    }

    public class ListNode {
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
    }

}
