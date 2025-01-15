package com.scadev.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void example1() {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(2d);
    }

    @Test
    void example2() {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(2.5);
    }

    @Test
    void example3() {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(1);
    }

    @Test
    void example4() {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1, 2};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(1.5);
    }

    @Test
    void example5() {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1, 2, 3};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(2);
    }

    @Test
    void example6() {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1, 2, 3, 4};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(2.5);
    }

    @Test
    void example7() {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1, 1};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(1);
    }

    @Test
    void example8() {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1, 1, 1};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(1);
    }

    @Test
    void example9() {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1, 1, 2};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(1);
    }

    @Test
    void example10() {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(0);
    }

    @Test
    void example11() {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(1);
    }

    @Test
    void example12() {
        int[] nums1 = new int[]{1, 1};
        int[] nums2 = new int[]{};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(1);
    }

    @Test
    void example13() {
        int[] nums1 = new int[]{1, 1, 1};
        int[] nums2 = new int[]{};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(1);
    }

    @Test
    void example14() {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(1.5);
    }

    @Test
    void example15() {
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(2);
    }

    @Test
    void example16() {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{1, 1, 1};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(1);
    }

    @Test
    void example17() {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{1, 2, 1};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(1.5);
    }

    @Test
    void example18() {
        int[] nums1 = new int[]{1, 3, 5};
        int[] nums2 = new int[]{2, 4, 6};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(3.5);
    }

    @Test
    void example19() {
        int[] nums1 = new int[]{1, 5, 6};
        int[] nums2 = new int[]{2, 3, 4};

        Solution s = new Solution();
        double res = s.findMedianSortedArrays(nums1, nums2);

        assertThat(res).isEqualTo(3.5);
    }


}