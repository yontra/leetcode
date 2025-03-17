package com.scadev.leetcode.id2598;

class Solution {

    public int findSmallestInteger(int[] nums, int value) {
        if (nums == null || nums.length < 1 || nums.length > Math.pow(10, 5)) {
            return 0;
        }

        if (value < 1 || value > Math.pow(10, 5)) {
            return 0;
        }

        for (int val : nums) {
            if (val < (-1) * Math.pow(10, 9) || val > Math.pow(10, 9)) {
                return 0;
            }
        }

        // calculate reminder for each input number
        int[] reminders = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // floor mod ensure positive value reminder
            int reminder = Math.floorMod(nums[i], value);
            reminders[i] = reminder;
        }

        // calculate frequency of each reminder value
        int[] frequency = new int[value];
        for (int r : reminders) {
            frequency[r]++;
        }

        // find the smallest missing integer
        // increment x from 0 to inf+
        // check if we have x%value (reminder) in frequency array
        // if we have lower freq of each reminder by 1
        // otherwise we struck missing integer
        for (int x = 0; ; x++) {
            if (frequency[x % value] == 0) {
                return x;
            }
            frequency[x % value]--;
        }
    }
}
