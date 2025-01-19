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
        list.add(new Data(-1234, -4321));
        list.add(new Data(120, 21));
        list.add(new Data(1, 1));
        list.add(new Data(10, 1));
        list.add(new Data(100, 1));
        list.add(new Data(1200, 21));
        list.add(new Data(2147483647, 0));
        list.add(new Data(2147483647, 0));
        list.add(new Data(1463847412, 2147483641));
        list.add(new Data(-2147483648, 0));
        list.add(new Data(-2147483412, -2143847412));
        list.add(new Data(1563847412, 0));

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

    @Test
    void test() {
        boolean x = -1 > -3;
        boolean y = -3 > -2;
    }
}