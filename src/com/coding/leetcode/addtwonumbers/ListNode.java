package com.coding.leetcode.addtwonumbers;

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
