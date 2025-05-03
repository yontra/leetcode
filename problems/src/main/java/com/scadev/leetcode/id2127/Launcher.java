package com.scadev.leetcode.id2127;

public class Launcher {

    public static void main(String[] args) {
        int[] val = new int[100000];
        for (int i = 0; i < val.length - 5; i++) {
            val[i] = i + 5;
        }
        val[99994] = 99999;
        val[99995] = 99999;
        val[99996] = 99999;
        val[99997] = 99999;
        val[99998] = 99999;
        val[99999] = 99998;

        var s = new Solution();
        var res = s.maximumInvitations(val);
        System.out.println("Val: " + res);
    }

}
