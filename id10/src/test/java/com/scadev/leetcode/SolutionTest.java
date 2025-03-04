package com.scadev.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void isMatch() {
        List<Data> list = new ArrayList<>();
        list.add(new Data("a", ".*..a*", false));
        list.add(new Data("abcd", "d*", false));
        list.add(new Data("bbbba", ".*a*a", true));
        list.add(new Data("a", "ab*a", false));
        list.add(new Data("ab", ".*c", false));
        list.add(new Data("aab", "c*a*b", true));
        list.add(new Data("aa", "a", false));
        list.add(new Data("aa", "a*", true));
        list.add(new Data("ab", ".*", true));
        list.add(new Data("aabb", "aabb", true));
        list.add(new Data("aabb", "a", false));
        list.add(new Data("aabb", "aa", false));
        list.add(new Data("aabb", "aab", false));
        list.add(new Data("aabb", "aab.", true));
        list.add(new Data("aabb", "aab*", true));
        list.add(new Data("aaa", "aaaa", false));

        Solution s = new Solution();
        for (Data data : list) {
            boolean result = s.isMatch(data.in, data.pattern);
            assertThat(result).withFailMessage("s: %s, p: %s, expected: %s", data.in, data.pattern, data.out).isEqualTo(data.out);
        }
    }

    static class Data {
        String in;
        String pattern;
        boolean out;

        Data(String in, String pattern, boolean out) {
            this.in = in;
            this.pattern = pattern;
            this.out = out;
        }
    }

}
