package com.scadev.leetcode.id2206;

class Solution {
    public boolean divideArray(int[] nums) {
        if (nums == null || nums.length < 1 || nums.length > 1000 || nums.length % 2 == 1) {
            return false;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        for (int i = 0; i < n; i = i + 2) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }

        }

        return true;
    }

}
