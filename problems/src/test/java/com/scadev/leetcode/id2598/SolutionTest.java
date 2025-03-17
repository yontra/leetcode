package com.scadev.leetcode.id2598;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void findSmallestInteger() {
        List<Data> list = new ArrayList<>();
        list.add(new Data(new int[]{1, -10, 7, 13, 6, 8}, 5, 4));
        list.add(new Data(new int[]{1, -10, 7, 13, 6, 8}, 7, 2));
        list.add(new Data(new int[]{3, 0, 3, 2, 4, 2, 1, 1, 0, 4}, 5, 10));

        Solution s = new Solution();
        for (Data d : list) {
            int result = s.findSmallestInteger(d.nums, d.value);

            var msg = String.format("n:%s,v:%d,exp:%d,res:%d", Arrays.toString(d.nums), d.value, d.expected, result);
            assertThat(result).withFailMessage(msg).isEqualTo(d.expected);
        }
    }

    static class Data {
        final int[] nums;
        final int value;
        final int expected;

        Data(int[] nums, int value, int expected) {
            this.nums = nums;
            this.value = value;
            this.expected = expected;
        }
    }
}