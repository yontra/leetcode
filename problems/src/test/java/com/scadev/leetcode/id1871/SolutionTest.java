package com.scadev.leetcode.id1871;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void canReach() {
        List<Data> list = new ArrayList<>();
        list.add(new Data("01011000011110100110100100010101101010101100001010010010111000010000010111101101111111010000011111110110100110000001110", 1, 6, false));
        list.add(new Data("011001110001000", 3, 5, true));
        list.add(new Data("0".repeat(100_000), 1, 1, true));
        list.add(new Data("00111010", 3, 5, false));
        list.add(new Data("011010", 2, 3, true));
        list.add(new Data("01101110", 2, 3, false));
        list.add(new Data("0x01", 1, 1, false));
        list.add(new Data("00", 1, 1, true));
        list.add(new Data("01", 1, 1, false));
        list.add(new Data("0000000000", 2, 5, true));
        list.add(new Data("0".repeat(100_000), 5, 99998, true));
        list.add(new Data("01111111111111111111111111111111111111111111101111111111111111111111111111111111110", 32, 52, true));
        list.add(new Data("01000110110", 2, 3, true));

        Solution s = new Solution();
        for (Data d : list) {
            boolean result = s.canReach(d.s, d.minJump, d.maxJump);
            assertThat(result).withFailMessage("%s, result=%b", d, result).isEqualTo(d.expected);
        }
    }

    record Data(String s, int minJump, int maxJump, boolean expected) {
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Data{s=");
            sb.append(this.s);
            sb.append(",jump=");
            sb.append(this.minJump);
            sb.append(",maxJump=");
            sb.append(this.maxJump);
            sb.append(",expected=");
            sb.append(this.expected);
            sb.append("}");

            return sb.toString();
        }
    }

}