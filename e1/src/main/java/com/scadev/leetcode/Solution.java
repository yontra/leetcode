package com.scadev.leetcode;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];

            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                int second = nums[j];
                int sum = first + second;
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

}
