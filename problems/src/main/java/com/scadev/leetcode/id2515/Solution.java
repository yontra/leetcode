package com.scadev.leetcode.id2515;

import java.util.Objects;

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        if (words == null || words.length < 1 || words.length > 100) {
            return -1;
        }

        if (target == null) {
            return -1;
        }

        // start index need to be inside [0,words.length -1]
        if (startIndex < 0 || startIndex >= words.length) {
            return -1;
        }

        int nextPos = startIndex;
        int prevPos = startIndex;
        int steps = 0;
        boolean found = false;

        for (int i = 0; i < words.length; i++) {
            if (this.isMatch(words, target, nextPos)) {
                found = true;
                break;
            }
            nextPos = (nextPos + 1) % words.length;

            if (this.isMatch(words, target, prevPos)) {
                found = true;
                break;
            }
            prevPos = (prevPos - 1 + words.length) % words.length;

            steps = steps + 1;
        }

        return found ? steps : -1;
    }

    private boolean isMatch(String[] words, String target, int pos) {
        String source = words[pos];
        return Objects.equals(source, target);
    }
}
