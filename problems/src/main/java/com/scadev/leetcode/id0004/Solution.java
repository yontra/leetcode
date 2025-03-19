package com.scadev.leetcode.id0004;

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isNum1Null = nums1 == null;
        boolean isNum2Null = nums2 == null;

        if (isNum1Null && isNum2Null) {
            return 0;
        }

        int[] aArr = isNum1Null ? new int[0] : nums1;
        int[] bArr = isNum2Null ? new int[0] : nums2;

        if (aArr.length < bArr.length) {
            int[] tmp = aArr;
            aArr = bArr;
            bArr = tmp;
        }

        int aSize = aArr.length;
        int bSize = bArr.length;

        if (aSize == 0 && bSize == 0) {
            return 0;
        }

        int mSize = aSize + bSize;
        int[] mArr = new int[mSize];

        int ciel = Math.ceilDiv(mSize-1, 2);
        int flor = Math.floorDiv(mSize-1, 2);

        int a = 0;
        int b = 0;
        for (int i = 0; i < mSize; i++) {
            boolean hasA = a < aSize;
            boolean hasB = b < bSize;

            if (hasA && hasB) {
                int aVal = aArr[a];
                int bVal = bArr[b];
                if (aVal == bVal) {
                    mArr[i] = aVal;
                    a++;
                } else if (aVal < bVal) {
                    mArr[i] = aVal;
                    a++;
                } else {
                    mArr[i] = bVal;
                    b++;
                }
            } else if (hasA) {
                mArr[i] = aArr[a];
                a++;
            } else {
                mArr[i] = bArr[b];
                b++;
            }

            if (ciel == i) {
                if (flor == ciel) {
                    return mArr[ciel];
                } else {
                    return (double) (mArr[flor] + mArr[ciel]) / 2;
                }
            }
        }

        return 0;
    }

}
