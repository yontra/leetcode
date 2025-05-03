package com.scadev.leetcode.id2127;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void maximumInvitations() {
        List<Data> list = new ArrayList<>();
        list.add(new Data(new int[]{1, 0, 0, 2, 1, 4, 7, 8, 9, 6, 7, 10, 8}, 6));
        list.add(new Data(new int[]{2, 2, 1, 2}, 3));
        list.add(new Data(new int[]{1, 2, 0}, 3));
        list.add(new Data(new int[]{3, 0, 1, 4, 1}, 4));
        list.add(new Data(new int[]{1, 2, 3, 4, 5, 6, 3, 8, 9, 10, 11, 8}, 4));

        int[] val = new int[100000];
        for (int i = 0; i < val.length - 5; i++) {
            val[i] = i + 5;
        }
        val[99994] = 99999;
        val[99995] = 99999;
        val[99996] = 99999;
        val[99997] = 99999;
        val[99998] = 99999;
        val[99999] = 99998;

        list.add(new Data(val, 40001));

        Solution s = new Solution();
        for (var d : list) {
            int result = s.maximumInvitations(d.favorite);
            String msg = String.format("%s, expected:%d, result:%d", Arrays.toString(d.favorite), d.expected, result);
            assertThat(result).withFailMessage(msg).isEqualTo(d.expected);
        }
    }

    static class Data {
        int[] favorite;
        int expected;

        Data(int[] favorite, int expected) {
            this.favorite = favorite;
            this.expected = expected;
        }
    }

}