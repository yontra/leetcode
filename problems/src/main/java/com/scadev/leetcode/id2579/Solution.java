package com.scadev.leetcode.id2579;

class Solution {

    public long coloredCells(int n) {
        if (n < 1) {
            return 0;
        }

        // size is column (and row) number of matrix that fits all tiles
        long size = (n * 2L) - 1;
        // total is number of tiles in that matrix (rows * cols)
        long total = size * size;

        // inverse calculation, calculate number of tiles that are NOT blue
        // in one quadrant
        long q = 0;
        for (int i = 1; i <= n - 1; i++) {
            q = q + i;
        }

        // there are 4 quadrants, so multiply that by 4
        long all = q * 4;

        // subtract NOT blue tiles from all tiles give us number of blue tiles
        return total - all;
    }

}