package com.scadev.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void maxArea() {
        List<Data> list = new ArrayList<>();
        list.add(new Data(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49));
        list.add(new Data(new int[]{1, 1}, 1));

        Solution s = new Solution();
        for (Data data : list) {
            int result = s.maxArea(data.in);
            var msg = String.format("height: %s, expected: %d, actual: %d", Arrays.toString(data.in), data.out, result);
            assertThat(result).withFailMessage(msg).isEqualTo(data.out);
        }
    }

    static class Data {
        int[] in;
        int out;

        Data(int[] in, int out) {
            this.in = in;
            this.out = out;
        }
    }

}