package com.scadev.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void twoSumExample1() {

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        Solution s = new Solution();
        int[] result = s.twoSum(nums, target);

        assertThat(result).containsExactlyInAnyOrder(0, 1);
    }

    @Test
    void twoSumExample2() {

        int[] nums = new int[]{3, 2, 4};
        int target = 6;

        Solution s = new Solution();
        int[] result = s.twoSum(nums, target);

        assertThat(result).containsExactlyInAnyOrder(1, 2);
    }

    @Test
    void twoSumExample3() {

        int[] nums = new int[]{3, 3};
        int target = 6;

        Solution s = new Solution();
        int[] result = s.twoSum(nums, target);

        assertThat(result).containsExactlyInAnyOrder(0, 1);
    }
}