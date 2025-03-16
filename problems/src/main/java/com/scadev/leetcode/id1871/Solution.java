package com.scadev.leetcode.id1871;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public boolean canReach(String s, int minJump, int maxJump) {
        if (s == null || s.length() < 2 || s.length() > Math.pow(10, 5)) {
            return false;
        }

        if (s.charAt(0) != '0') {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (!(x == '0' || x == '1')) {
                return false;
            }
        }

        if (!(1 <= minJump && minJump <= maxJump && maxJump < s.length())) {
            return false;
        }

        int n = s.length();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        int farthest = 0;

        while (!queue.isEmpty()) {
            int index = queue.poll();

            int start = Math.max(index + minJump, farthest + 1);
            int end = Math.min(index + maxJump, n - 1);

            for (int i = start; i <= end; i++) {
                if (s.charAt(i) == '0') {
                    if (i == n - 1) {
                        return true;
                    }

                    queue.offer(i);
                }
            }

            farthest = end;
        }

        return false;
    }
}
