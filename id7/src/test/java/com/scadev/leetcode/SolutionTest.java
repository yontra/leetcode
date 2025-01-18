package com.scadev.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void reverse() {
        List<Data> list = new ArrayList<>();
        list.add(new Data(123, 321));
        list.add(new Data(-123, -321));
        list.add(new Data(120, 21));

        Solution s = new Solution();
        for (Data data : list) {
            int result = s.reverse(data.in);

            assertThat(result).isEqualTo(data.out);
        }
    }

    private static class Data {
        int in;
        int out;

        Data(int in, int out) {
            this.in = in;
            this.out = out;
        }
    }
}