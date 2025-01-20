package com.scadev.leetcode;

public class Solution {

    public int myAtoi(String s) {
        if (s == null || s.isEmpty() || s.length() > 200) {
            return 0;
        }

        int firstChar = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                firstChar = i;
                break;
            }
        }

        if (firstChar < 0) {
            return 0;
        }

        // has at least 1 char that is not whitespace (' ')
        String signedNumberString = s.substring(firstChar);

        char signChar = signedNumberString.charAt(0);
        boolean isSignedNumber = signChar == '-' || signChar == '+';

        // check if number sign ('-' or '+') is only character left
        if (isSignedNumber && signedNumberString.length() == 1) {
            return 0;
        }

        boolean isNumberNegative = isSignedNumber && (signChar == '-');

        // skip number sign
        String zeroPrefixedNumberString = isSignedNumber ? signedNumberString.substring(1) : signedNumberString;

        // skip zero ('0') characters in number prefix
        int firstNonZero = -1;
        for (int i = 0; i < zeroPrefixedNumberString.length(); i++) {
            char c = zeroPrefixedNumberString.charAt(i);
            if (c != '0') {
                firstNonZero = i;
                break;
            }
        }

        if (firstNonZero < 0) {
            return 0;
        }

        // has at least 1 char that is not zero ('0')
        String numberWithSufixString = zeroPrefixedNumberString.substring(firstNonZero);

        int numberEndChar = numberWithSufixString.length();
        for (int i = 0; i < numberWithSufixString.length(); i++) {
            char c = numberWithSufixString.charAt(i);
            if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9') {
                numberEndChar = i;
                break;
            }
        }

        if (numberEndChar < 1) {
            return 0;
        }

        String numberString = numberWithSufixString.substring(0, numberEndChar);
        int[] numberTmpArr = new int[numberString.length()];
        for (int i = 0; i < numberString.length(); i++) {
            char c = numberString.charAt(i);
            int d = c - '0';
            numberTmpArr[i] = isNumberNegative ? d * (-1) : d;
        }

        int[] numberArr = new int[numberTmpArr.length];
        for (int i = numberTmpArr.length - 1, j = 0; i >= 0; j++, i--) {
            numberArr[j] = numberTmpArr[i];
        }

        int prod = 1;
        for (int i = 0; i < 31; i++) {
            prod = prod * 2;
        }
        int minInt = prod;
        int maxInt = prod - 1;

        int[] minIntArr = this.intToArray(minInt);
        int[] maxIntArr = this.intToArray(maxInt);

        // rounding

        // when number has more digits than min or max, return min or max
        if (numberArr.length > minIntArr.length) {
            if (isNumberNegative) {
                return minInt;
            } else {
                return maxInt;
            }
        }

        // when number and min/max has equal number of digits
        // check for overflow
        if (numberArr.length == minIntArr.length) {
            boolean overflow = false;
            if (isNumberNegative) {
                for (int i = numberArr.length - 1; i >= 0; i--) {
                    int no = numberArr[i];
                    int minNo = minIntArr[i];
                    if (no < minNo) {
                        overflow = true;
                        break;
                    } else if (no > minNo) {
                        break;
                    }
                }
                if (overflow) {
                    return minInt;
                }
            } else {
                for (int i = numberArr.length - 1; i >= 0; i--) {
                    int no = numberArr[i];
                    int maxNo = maxIntArr[i];
                    if (no > maxNo) {
                        overflow = true;
                        break;
                    } else if (no < maxNo) {
                        break;
                    }
                }
                if (overflow) {
                    return maxInt;
                }
            }
        }

        // when number has less or equal digits than min/max, return number
        int scale = 1;
        int total = 0;
        for (int i = 0; i < numberArr.length; i++) {
            int x = numberArr[i];
            total = total + (x * scale);
            scale = scale * 10;
        }


        return total;
    }

    private int[] intToArray(int x) {
        int quotient = x;
        int sum = 0;
        int factor = 1;
        int[] arr = new int[0];
        while (sum != x) {
            int digit = quotient % 10;
            arr = this.arrayAdd(arr, digit);
            quotient = quotient / 10;
            sum = sum + (digit * factor);
            factor = factor * 10;
        }

        return arr;
    }

    private int[] arrayAdd(int[] in, int x) {
        if (in.length == 0) {
            int[] out = new int[1];
            out[0] = x;
        }

        int[] out = new int[in.length + 1];
        for (int i = 0; i < in.length; i++) {
            out[i] = in[i];
        }
        out[out.length - 1] = x;

        return out;
    }
}
