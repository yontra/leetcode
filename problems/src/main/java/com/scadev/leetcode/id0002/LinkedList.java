package com.scadev.leetcode.id0002;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    private ListNode head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(ListNode node) {
        this.head = node;
    }

    public void push(int val) {
        this.head = new ListNode(val, this.head);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LinkedList other)) {
            return false;
        }

        ListNode a = this.head;
        ListNode b = other.head;

        while (a != null && b != null) {
            if (a.val != b.val) {
                return false;
            }

            a = a.next;
            b = b.next;
        }

        return (a == null && b == null);
    }

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        ListNode a = this.head;
        while (a != null) {
            list.add(String.valueOf(a.val));
            a = a.next;
        }

        return String.join(",", list);
    }

}
