package com.scadev.leetcode.id2206;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void divideArray() {
        List<Data> list = new ArrayList<>();
        list.add(new Data(new int[]{9, 4, 18, 3, 2, 6, 18, 15, 7, 15, 6, 4, 15, 14, 7, 4, 15, 4, 3, 17, 9, 13, 13, 12, 2, 14, 12, 17}, true));
        list.add(new Data(new int[]{3, 2, 3, 2, 2, 2}, true));
        list.add(new Data(new int[]{1, 2, 3, 4}, false));

        Solution s = new Solution();
        for (var d : list) {
            boolean result = s.divideArray(d.nums);
            var msg = String.format("%s, exp=%b, res=%b", Arrays.toString(d.nums), d.expected, result);
            assertThat(result).withFailMessage(msg).isEqualTo(d.expected);
        }
    }

    static class Data {
        final int[] nums;
        final boolean expected;

        Data(int[] nums, boolean expected) {
            this.nums = nums;
            this.expected = expected;
        }
    }
}