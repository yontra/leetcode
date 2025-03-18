package com.scadev.leetcode.id2515;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void closestTarget() {
        List<Data> list = new ArrayList<>();
        list.add(new Data(new String[]{"hello", "i", "am", "leetcode", "hello"}, "hello", 1, 1));
        list.add(new Data(new String[]{"a", "b", "leetcode"}, "leetcode", 0, 1));
        list.add(new Data(new String[]{"i", "eat", "leetcode"}, "ate", 0, -1));

        Solution s = new Solution();
        for (var d : list) {
            int result = s.closestTarget(d.words, d.target, d.startIndex);
            var msg = String.format("[%s], %s, %d, exp=%d, res=%d", String.join(",", d.words), d.target, d.startIndex, d.expected, result);
            assertThat(result).withFailMessage(msg).isEqualTo(d.expected);
        }
    }

    static final class Data {
        final String[] words;
        final String target;
        final int startIndex;
        final int expected;

        Data(String[] words, String target, int startIndex, int expected) {
            this.words = words;
            this.target = target;
            this.startIndex = startIndex;
            this.expected = expected;
        }
    }

}