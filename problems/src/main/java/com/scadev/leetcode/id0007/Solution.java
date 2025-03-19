package com.scadev.leetcode.id0007;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int reverse(int x) {
        int prod = 1;
        for (int i = 0; i < 31; i++) {
            prod = prod * 2;
        }
        int min = prod;
        int max = prod - 1;

        List<Integer> minDigits = this.pullDigits(min);
        List<Integer> maxDigits = this.pullDigits(max);

        List<Integer> digits = this.pullDigits(x);
        int factor = 1;
        for (int i = 0; i < digits.size() - 1; i++) {
            factor = factor * 10;
        }

        boolean isOverflowPossible = digits.size() == maxDigits.size();
        boolean hasTrailingZeroes = true;
        int result = 0;
        for (int i = 0; i < digits.size(); i++) {
            int val = digits.get(i);
            if (hasTrailingZeroes) {
                if (val != 0) {
                    hasTrailingZeroes = false;
                } else {
                    factor = factor / 10;
                    continue;
                }
            }

            if (isOverflowPossible) {
                if (val > 0) {
                    int limitVal = maxDigits.get(maxDigits.size() - 1 - i);
                    if (val > limitVal) {
                        return 0;
                    } else if (val < limitVal) {
                        isOverflowPossible = false;
                    }
                } else {
                    int limitVal = minDigits.get(minDigits.size() - 1 - i);
                    if (val < limitVal) {
                        return 0;
                    } else if (val > limitVal) {
                        isOverflowPossible = false;
                    }
                }
            }

            result = result + (val * factor);
            factor = factor / 10;
        }

        return result;
    }

    private List<Integer> pullDigits(int val) {
        int dividend = val;
        int sum = 0;
        int factor = 1;
        List<Integer> digits = new ArrayList<>();
        while (sum != val) {
            int lastDigit = dividend % 10;
            digits.add(lastDigit);

            sum = sum + (lastDigit * factor);

            dividend = dividend / 10;
            factor *= 10;
        }

        return digits;
    }

}
