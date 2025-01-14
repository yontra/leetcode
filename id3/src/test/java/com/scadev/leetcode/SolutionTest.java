package com.scadev.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();
        int result = s.lengthOfLongestSubstring("abcabcbb");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void example2() {
        Solution s = new Solution();
        int result = s.lengthOfLongestSubstring("bbbbb");

        assertThat(result).isEqualTo(1);
    }

    @Test
    void example3() {
        Solution s = new Solution();
        int result = s.lengthOfLongestSubstring("pwwkew");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void example4() {
        Solution s = new Solution();
        int result = s.lengthOfLongestSubstring("aab");

        assertThat(result).isEqualTo(2);
    }

    @Test
    void example5() {
        Solution s = new Solution();
        int result = s.lengthOfLongestSubstring("dvdf");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void example6() {
        Solution s = new Solution();
        int result = s.lengthOfLongestSubstring("dvdvf");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void example7() {
        Solution s = new Solution();
        int result = s.lengthOfLongestSubstring("asjrgapa");

        assertThat(result).isEqualTo(6);
    }

}