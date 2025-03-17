package com.scadev.leetcode.id0982;

class Solution {

    public int countTriplets(int[] nums) {
        if (nums == null || nums.length < 1 || nums.length > 1000) {
            return 0;
        }

        int triplets = 0;

        // compute all (i & j) and store their count
        int[] freq = new int[(int) Math.pow(2, 16)];
        for (int i : nums) {
            for (int j : nums) {
                freq[i & j]++;
            }
        }

        // check k against precomputed (i & j)
        for (int k : nums) {
            for (int x = 0; x < freq.length; x++) {
                int res = k & x;
                if (res == 0) {
                    triplets += freq[x];
                }
            }
        }

        return triplets;
    }

}
