package com.scadev.leetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private static Map<String, String> examples;

    @BeforeAll
    static void beforeAll() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("aa", "aa");
        map.put("ab", "a");
        map.put("ba", "b");
        map.put("aaa", "aaa");
        map.put("aba", "aba");
        map.put("aab", "aa");
        map.put("baa", "aa");
        map.put("baab", "baab");
        map.put("aabaa", "aabaa");
        map.put("babad", "bab");
        map.put("cbbd", "bb");

        examples = map;
    }

    @Test
    void testLongestPalindrome() {
        Solution s = new Solution();
        for (var entry : examples.entrySet()) {
            String input = entry.getKey();
            String expected = entry.getValue();

            String output = s.longestPalindrome(input);
            assertThat(output).isEqualTo(expected);
        }
    }

}