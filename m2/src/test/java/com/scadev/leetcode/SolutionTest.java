package com.scadev.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void example1() {
        var l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        var l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        var solution = new Solution();
        var result = solution.addTwoNumbers(l1, l2);

        var resultList = new LinkedList(result);

        var expectedList = new LinkedList();
        expectedList.push(8);
        expectedList.push(0);
        expectedList.push(7);

        assertThat(resultList).isEqualTo(expectedList);
    }

    @Test
    void example2() {
        var l1 = new ListNode(0);
        var l2 = new ListNode(0);

        var solution = new Solution();
        var result = solution.addTwoNumbers(l1, l2);

        var resultList = new LinkedList(result);
        var expectedList = new LinkedList(new ListNode(0));

        assertThat(resultList).isEqualTo(expectedList);
    }

    @Test
    void example3() {
        var l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        var l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        var solution = new Solution();
        var result = solution.addTwoNumbers(l1, l2);

        var resultList = new LinkedList(result);
        var expectedList = new LinkedList();
        expectedList.push(1);
        expectedList.push(0);
        expectedList.push(0);
        expectedList.push(0);
        expectedList.push(9);
        expectedList.push(9);
        expectedList.push(9);
        expectedList.push(8);

        assertThat(resultList).isEqualTo(expectedList);
    }
}