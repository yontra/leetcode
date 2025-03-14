package com.scadev.leetcode.id1530;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public int countPairs(TreeNode root, int distance) {
        if (root == null) {
            return 0;
        }

        TaggedNode taggedRoot = this.buildTaggedNodeTree(root);
        List<TaggedNode> leafs = this.findLeafNodes(taggedRoot);

        List<NodeDistance> distances = new ArrayList<>();
        for (int i = 0; i < leafs.size(); i++) {
            TaggedNode u = leafs.get(i);

            int n = i + 1;
            if (n == leafs.size()) {
                continue;
            }

            for (int j = n; j < leafs.size(); j++) {
                TaggedNode v = leafs.get(j);
                TaggedNode lca = this.findLCA(u, v);

                // dist(u,v) = depth(u) + depth(v) - 2 * depth [LCA(u,v)]
                NodeDistance nd = new NodeDistance(u, v, (u.depth + v.depth - 2 * lca.depth));
                distances.add(nd);
            }
        }

        int pairs = 0;
        for (NodeDistance d : distances) {
            if (d.distance <= distance) {
                pairs = pairs + 1;
            }
        }

        return pairs;

    }


    private List<TaggedNode> findLeafNodes(TaggedNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Deque<TaggedNode> q = new ArrayDeque<>();
        q.add(root);

        List<TaggedNode> leafs = new ArrayList<>();
        while (!q.isEmpty()) {
            TaggedNode curr = q.poll();
            boolean isLeftNull = curr.left == null;
            boolean isRightNull = curr.right == null;

            // check if leaf node
            if (isLeftNull && isRightNull) {
                leafs.add(curr);
            }

            if (!isLeftNull) {
                q.offer(curr.left);
            }

            if (!isRightNull) {
                q.offer(curr.right);
            }
        }

        return leafs;
    }

    TaggedNode findLCA(TaggedNode u, TaggedNode v) {
        var uu = u;
        var vv = v;

        // Equalize depths
        while (uu.depth != vv.depth) {
            if (uu.depth > vv.depth) {
                if (uu.parent == null) {
                    break;
                }

                uu = new TaggedNode(uu.id, uu.val, uu.depth - 1, uu.parent.parent);
            } else {
                if (vv.parent == null) {
                    break;
                }

                vv = new TaggedNode(vv.id, vv.val, vv.depth - 1, vv.parent.parent);
            }
        }

        // Move up together until they meet
        while ((uu.parent != null && vv.parent != null) && (uu.parent.id != vv.parent.id)) {
            uu = new TaggedNode(uu.id, uu.val, uu.depth - 1, uu.parent.parent);
            vv = new TaggedNode(vv.id, vv.val, vv.depth - 1, vv.parent.parent);
        }


        return uu.parent;
    }


    private static class NodeDistance {
        TaggedNode u;
        TaggedNode v;
        int distance;

        NodeDistance(TaggedNode u, TaggedNode v, int distance) {
            this.u = u;
            this.v = v;
            this.distance = distance;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("u=");
            sb.append(this.u.val);
            sb.append(",v=");
            sb.append(this.v.val);
            sb.append(",distance=");
            sb.append(this.distance);

            return sb.toString();
        }
    }

    TaggedNode buildTaggedNodeTree(TreeNode tree) {
        if (tree == null) {
            return null;
        }

        Deque<TreeNode> treeQueue = new ArrayDeque<>();
        Deque<TaggedNode> idQueue = new ArrayDeque<>();

        int id = 0;
        var root = new TaggedNode(id, tree.val);

        idQueue.offer(root);
        treeQueue.offer(tree);

        while (!treeQueue.isEmpty()) {
            var current = treeQueue.poll();
            var parent = idQueue.poll();

            if (current.left != null && parent != null) {
                var treeLeft = current.left;
                var idLeft = new TaggedNode(id++, treeLeft.val, parent.depth + 1, parent);
                parent.left = idLeft;
                idQueue.offer(idLeft);
                treeQueue.offer(treeLeft);
            }

            if (current.right != null && parent != null) {
                var treeRight = current.right;
                var idRight = new TaggedNode(id++, treeRight.val, parent.depth + 1, parent);
                parent.right = idRight;
                idQueue.offer(idRight);
                treeQueue.offer(treeRight);
            }
        }

        return root;
    }

    static class TaggedNode {
        int id;
        int depth;
        int val;
        TaggedNode parent;
        TaggedNode left;
        TaggedNode right;

        TaggedNode() {
        }

        TaggedNode(int id, int val) {
            this.id = id;
            this.val = val;
        }

        TaggedNode(int id, int val, int depth, TaggedNode parent) {
            this.id = id;
            this.val = val;
            this.depth = depth;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return String.format("id:%d,val:%d,depth:%d", this.id, this.val, this.depth);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static TreeNode buildTree(List<Integer> values) {
            if (values.isEmpty() || values.getFirst() == null) {
                return null;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(values.getFirst());
            queue.add(root);
            int i = 1;

            while (!queue.isEmpty() && i < values.size()) {
                TreeNode node = queue.poll();
                if (values.get(i) != null) {
                    node.left = new TreeNode(values.get(i));
                    queue.add(node.left);
                }
                i++;
                if (i < values.size() && values.get(i) != null) {
                    node.right = new TreeNode(values.get(i));
                    queue.add(node.right);
                }
                i++;
            }

            return root;
        }

        @Override
        public String toString() {
            List<Integer> result = new ArrayList<>();

            Deque<Optional<TreeNode>> q = new ArrayDeque<>();
            q.add(Optional.of(this));
            while (!q.isEmpty()) {
                var current = q.pop();
                if (current.isPresent()) {
                    var node = current.get();
                    result.add(node.val);
                    q.addLast(Optional.ofNullable(node.left));
                    q.addLast(Optional.ofNullable(node.right));
                } else {
                    result.add(null);
                }
            }

            // remove trailing null values
            while (!result.isEmpty() && result.getLast() == null) {
                result.removeLast();
            }

            return result.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        }
    }
}