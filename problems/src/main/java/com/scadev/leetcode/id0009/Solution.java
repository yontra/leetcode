package com.scadev.leetcode.id0009;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        int sum = 0;
        int factor = 1;
        int tmp = x;

        int[] arr = new int[0];
        while (sum != x) {
            int lastDigit = tmp % 10;
            tmp = tmp / 10;
            arr = append(arr, lastDigit);
            sum = sum + (lastDigit * factor);
            factor = factor * 10;
        }

        boolean isEqual = true;
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            int l = arr[i];
            int r = arr[j];
            if (l != r) {
                isEqual = false;
                break;
            }
        }

        return isEqual;
    }

    private int[] append(int[] arr, int x) {
        if (arr.length == 0) {
            return new int[]{x};
        }

        int[] result = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        result[arr.length] = x;

        return result;
    }
}
