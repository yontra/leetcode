package com.scadev.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testConvert() {
        List<Data> list = new ArrayList<>();
        list.add(new Data("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"));
        list.add(new Data("PAYPALISHIRING", 4, "PINALSIGYAHRPI"));


        Solution s = new Solution();
        for (Data data : list) {
            String result = s.convert(data.in, data.numRows);

            assertThat(result).isEqualTo(data.out);
        }

    }

    private static class Data {
        String in;
        Integer numRows;
        String out;

        Data(String in, Integer numRows, String out) {
            this.in = in;
            this.numRows = numRows;
            this.out = out;
        }
    }

}