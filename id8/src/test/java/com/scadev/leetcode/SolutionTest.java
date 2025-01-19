package com.scadev.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void myAtoi() {
        List<Data> list = new ArrayList<>();
        list.add(new Data("42", 42));
        list.add(new Data("-042", -42));
        list.add(new Data("1337c0d3", 1337));
        list.add(new Data("0-1", 0));
        list.add(new Data("words and 987", 0));

        Solution s = new Solution();
        for (Data data : list) {
            int res = s.myAtoi(data.in);
            assertThat(res).isEqualTo(data.out);
        }
    }

    static class Data {
        String in;
        int out;

        Data(String in, int out) {
            this.in = in;
            this.out = out;
        }
    }

}