package com.scadev.leetcode;

public class Solution {

    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || s.length() > 1000 || numRows < 1 || numRows > 1000) {
            return "";
        }

        if (s.length() == 1 || numRows == 1) {
            return s;
        }

        int numCols = this.getColumnCount(s.length(), numRows);

        char[][] mat = new char[numRows][numCols];
        int i = 0;
        for (int col = 0; col < numCols; col++) {
            int segment = col % (numRows - 1);
            for (int row = 0; row < numRows; row++) {
                if (segment == 0) {
                    mat[row][col] = i < s.length() ? s.charAt(i) : '$';
                    i++;
                } else {
                    int zagRow = numRows - 1 - segment;
                    if (row == zagRow) {
                        mat[zagRow][col] = i < s.length() ? s.charAt(i) : '$';
                        i++;
                    } else {
                        mat[row][col] = '$';
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                char ch = mat[r][c];
                if (ch != '$') {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

    private int getColumnCount(int charsCount, int rows) {
        if (rows == 1) {
            return charsCount;
        }

        int cols = 0;
        int charsUsed = 0;
        while (charsUsed <= charsCount) {
            if (cols % (rows - 1) == 0) {
                charsUsed = charsUsed + rows;
            } else {
                charsUsed = charsUsed + 1;
            }
            cols = cols + 1;
        }

        return cols;
    }

}
