package com.scadev.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void isPalindrome() {
        List<Data> list = new ArrayList<>();
        list.add(new Data(121, true));
        list.add(new Data(-121, false));
        list.add(new Data(10, false));

        Solution s = new Solution();
        for (Data d : list) {
            boolean result = s.isPalindrome(d.in);
            assertThat(result).isEqualTo(d.out);
        }
    }

    static class Data {
        int in;
        boolean out;

        Data(int in, boolean out) {
            this.in = in;
            this.out = out;
        }
    }

}