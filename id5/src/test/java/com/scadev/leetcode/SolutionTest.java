package com.scadev.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void example1() {
        String input = "babad";

        Solution s = new Solution();
        String result = s.longestPalindrome(input);

        assertThat(result).isEqualTo("bab");
    }

    @Test
    void example2() {
        String input = "cbbd";

        Solution s = new Solution();
        String result = s.longestPalindrome(input);

        assertThat(result).isEqualTo("bb");
    }
}