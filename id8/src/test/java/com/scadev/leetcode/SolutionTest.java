package com.scadev.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void myAtoi() {
        List<Data> list = new ArrayList<>();
        list.add(new Data("1095502006p8", 1095502006));
        list.add(new Data("42", 42));
        list.add(new Data("-042", -42));
        list.add(new Data("1337c0d3", 1337));
        list.add(new Data("0-1", 0));
        list.add(new Data("words and 987", 0));
        list.add(new Data("", 0));
        list.add(new Data("a", 0));
        list.add(new Data("-", 0));
        list.add(new Data("+", 0));
        list.add(new Data(" ", 0));
        list.add(new Data("1", 1));
        list.add(new Data("12", 12));
        list.add(new Data("-12", -12));
        list.add(new Data("+12", 12));
        list.add(new Data(" 0", 0));
        list.add(new Data(" 000", 0));
        list.add(new Data(" 000a", 0));
        list.add(new Data(" 0001a", 1));
        list.add(new Data(" 0001a", 1));
        list.add(new Data(" +0", 0));
        list.add(new Data(" +000a", 0));
        list.add(new Data(" +00022a", 22));
        list.add(new Data(" -0", 0));
        list.add(new Data(" -000", 0));
        list.add(new Data(" -000a", 0));
        list.add(new Data(" -0001a", -1));
        list.add(new Data(" -00012a", -12));
        list.add(new Data("2147483647", 2147483647));
        list.add(new Data("2147483648", 2147483647));
        list.add(new Data("2147483800", 2147483647));
        list.add(new Data("21474836470", 2147483647));
        list.add(new Data("-2147483648", -2147483648));
        list.add(new Data("-3147483648", -2147483648));
        list.add(new Data("-21474836480", -2147483648));

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

    @Test
    void test() {
        Solution s = new Solution();
        s.myAtoi("    -000012");
    }

}