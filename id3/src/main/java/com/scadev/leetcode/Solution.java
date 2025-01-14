package com.scadev.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int largestSize = 0;
        int currentSize;
        List<Character> substring = new ArrayList<>(s.length());
        for(int x = 0; x < s.length(); x++) {
            substring.clear();
            for (int i = x; i < s.length(); i++) {
                char c = s.charAt(i);
                if (substring.contains(c)) {
                    break;
                }
                substring.add(c);
                currentSize = substring.size();

                if (currentSize > largestSize) {
                    largestSize = currentSize;
                }
            }
        }

        return largestSize;
    }

}
