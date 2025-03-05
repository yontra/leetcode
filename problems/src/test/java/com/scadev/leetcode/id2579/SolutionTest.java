package com.scadev.leetcode.id2579;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void coloredCells() {
        List<Data> list = new ArrayList<>();
        list.add(new Data(1, 1));
        list.add(new Data(2, 5));
        list.add(new Data(3, 13));
        list.add(new Data(4, 25));
        list.add(new Data(69675, 9709071901L));

        Solution s = new Solution();
        for (Data data : list) {
            long result = s.coloredCells(data.in);
            var msg = String.format("in: %d, out: %d, actual: %d", data.in, data.out, result);
            assertThat(result).withFailMessage(msg).isEqualTo(data.out);
        }
    }

    static class Data {
        int in;
        long out;

        Data(int in, long out) {
            this.in = in;
            this.out = out;
        }
    }

}
