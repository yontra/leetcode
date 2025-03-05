package com.scadev.leetcode.id2579;

class Solution {

    public long coloredCells(int n) {
        if (n < 1) {
            return 0;
        }

        long size = (n * 2L) - 1;
        long total = size * size;

        long q = 0;
        for (int i = 1; i <= n - 1; i++) {
            q = q + i;
        }

        long all = q * 4;

        return total - all;
    }

}