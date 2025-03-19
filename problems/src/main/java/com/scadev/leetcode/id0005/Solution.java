package com.scadev.leetcode.id0005;

public class Solution {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int length = s.length();

        if (length == 1) {
            return s;
        }

        for (int size = length; size > 0; size--) {
            for (int i = 0; i <= length - size; i++) {
                String substring = s.substring(i, i + size);
                if (isPalindrome(substring)) {
                    return substring;
                }
            }
        }

        return "";
    }

    public boolean isPalindrome(String str) {
        for (int x = 0, y = str.length() - 1; x < str.length(); x++, y--) {
            char front = str.charAt(x);
            char back = str.charAt(y);
            if (front != back) {
                return false;
            }
        }

        return true;
    }

}
