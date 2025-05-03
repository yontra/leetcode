package com.scadev.leetcode.id2127;

import java.util.*;

class Solution {
    public int maximumInvitations(int[] favorite) {
        if (favorite == null || favorite.length < 2 || favorite.length > Math.pow(10, 5)) {
            return 0;
        }

        Map<Integer, List<Integer>> adj = new HashMap<>(favorite.length);
        for (int i = 0; i < favorite.length; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < favorite.length; i++) {
            int val = favorite[i];
            if (val < 0 || val > (favorite.length - 1)) {
                return 0;
            }
            List<Integer> list = adj.get(val);
            list.add(i);
        }

        Set<List<Integer>> cycles = this.getCycles(favorite);

        int longestNCycle = 0;
        int total2Cycle = 0;
        for (var cycle : cycles) {
            if (cycle.size() > 2) {
                if (cycle.size() > longestNCycle) {
                    longestNCycle = cycle.size();
                }
            } else {
                int size = this.get2CycleLength(cycle.get(0), cycle.get(1), adj);
                total2Cycle += size;
            }
        }

        return Math.max(longestNCycle, total2Cycle);
    }

    private int get2CycleLength(int a, int b, Map<Integer, List<Integer>> adj) {
        int aLength = this.getMaxDepth(a, b, adj);
        int bLength = this.getMaxDepth(b, a, adj);

        return aLength + bLength + 2;
    }

    private int getMaxDepth(int a, int b, Map<Integer, List<Integer>> adj) {
        Set<Integer> seen = new HashSet<>();
        seen.add(b);

        Deque<List<Integer>> stack = new ArrayDeque<>();
        stack.add(List.of(a));

        int depth = 0;
        while (!stack.isEmpty()) {
            List<Integer> currentDepth = stack.pop();

            List<Integer> newDepth = new ArrayList<>();
            for (Integer parent : currentDepth) {
                List<Integer> children = adj.get(parent);
                for (Integer child : children) {
                    if (!seen.contains(child)) {
                        newDepth.add(child);
                    }
                }
            }

            if (newDepth.isEmpty()) {
                break;
            }

            stack.push(newDepth);
            depth++;
        }

        return depth;
    }

    Set<List<Integer>> getCycles(int[] adj) {
        Set<List<Integer>> cycles = new HashSet<>(adj.length);
        boolean[] visited = new boolean[adj.length];

        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                List<Integer> cycle = this.findCycle(i, adj);
                if(cycle.isEmpty()) {
                	continue;
                }

                int n = cycle.size();

                // find the smallest node in the cycle
                int smallest = Collections.min(cycle);
                int startIndex = cycle.indexOf(smallest);

                // normalize cycle order (rotate to start from the smallest node)
                List<Integer> sortedCycle = new ArrayList<>();
                for (int x = 0; x < cycle.size(); x++) {
                    int index = (startIndex + x) % n;
                    int val = cycle.get(index);
                    sortedCycle.add(val);
                    visited[val] = true;
                }

                cycles.add(sortedCycle);
            }
        }

        return cycles;
    }

    List<Integer> findCycle(int i, int[] adj) {
        boolean[] seen = new boolean[adj.length];
        List<Integer> path = new ArrayList<>(adj.length);

        int next = i;
        while (true) {
            boolean isVisited = seen[next];
            if (isVisited) {
                // we detected cycle
                // extract it from path and return

                int idx = path.indexOf(next);
                return path.subList(idx, path.size());
            }
            path.add(next);
            seen[next] = true;
            next = adj[next];
        }
    }

}
