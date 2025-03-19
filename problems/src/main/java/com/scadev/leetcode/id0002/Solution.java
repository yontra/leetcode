package com.scadev.leetcode.id0002;

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;

        ListNode result = null;
        ListNode last = null;
        int reminder = 0;
        while (a != null || b != null) {
            int v1 = 0;
            int v2 = 0;

            if (a != null) {
                v1 = a.val;
                a = a.next;
            }

            if (b != null) {
                v2 = b.val;
                b = b.next;
            }

            int total = v1 + v2 + reminder;
            int value = total % 10;
            reminder = total / 10;

            ListNode valueNode = new ListNode(value);
            if (result == null) {
                result = valueNode;
            } else {
                last.next = valueNode;
            }
            last = valueNode;
        }

        if (reminder != 0) {
            last.next = new ListNode(reminder);
        }

        return result == null ? new ListNode(0) : result;
    }

}
