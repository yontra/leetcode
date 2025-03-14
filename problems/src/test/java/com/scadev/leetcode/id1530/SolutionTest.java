package com.scadev.leetcode.id1530;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void countPairs() {
        List<Data> list = new ArrayList<>();
        list.add(new Data(Arrays.asList(1, 2, 3, null, 4), 3, 1));
        list.add(new Data(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3, 2));
        list.add(new Data(Arrays.asList(7, 1, 4, 6, null, 5, 3, null, null, null, null, null, 2), 3, 1));
        list.add(new Data(Arrays.asList(80, null, 3, 95, 28, null, null, null, 28), 3, 1));

        Solution s = new Solution();
        for (Data data : list) {
            int result = s.countPairs(data.root, data.distance);
            var msg = String.format("tree: %s, distance: %d expected: %d, actual: %d", data.root, data.distance, data.expected, result);
            assertThat(result).withFailMessage(msg).isEqualTo(data.expected);
        }
    }

    static class Data {
        Solution.TreeNode root;
        int distance;
        int expected;

        Data(List<Integer> root, int distance, int expected) {
            this.root = Solution.TreeNode.buildTree(root);
            this.distance = distance;
            this.expected = expected;
        }
    }

}