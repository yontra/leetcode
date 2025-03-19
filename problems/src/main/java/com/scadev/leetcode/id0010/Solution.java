package com.scadev.leetcode.id0010;

public class Solution {
    public boolean isMatch(String s, String p) {
        Matcher m = Tokenizer.pattern(p);
        return m.match(s);
    }

    static class Tokenizer {

        static Matcher pattern(String pattern) {
            char[] p = pattern.toCharArray();
            Matcher m = new Matcher();

            int i = 0;
            while (i < p.length) {
                char c = p[i];

                Node currentNode;
                if (c == '.') {
                    currentNode = new DotNode();
                } else {
                    currentNode = new CharNode(c);
                }

                boolean isLast = (i + 1) >= p.length;
                if (!isLast) {
                    char n = p[i + 1];
                    if (n == '*') {
                        m.addLast(new StarNode(c));
                        i++;
                    } else {
                        m.addLast(currentNode);
                    }
                } else {
                    m.addLast(currentNode);
                }

                i++;
            }

            return m;
        }

    }

    static class Matcher {
        Node head;
        Node tail;

        Matcher() {
            this.head = null;
            this.tail = null;
        }

        void addLast(Node node) {
            if (this.head == null) {
                this.head = node;
            } else {
                Node curr = this.head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = node;
                node.prev = curr;
            }
        }

        boolean match(String in) {
            return this.head.match(in.toCharArray());
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node curr = this.head;
            do {
                sb.append(curr);
                curr = curr.next;
            } while (curr != null);

            return sb.toString();
        }
    }

    abstract static class Node {
        Node prev;
        Node next;

        abstract boolean match(char[] in);
    }

    static class CharNode extends Node {

        private final char element;

        CharNode(char element) {
            this.element = element;
        }

        @Override
        boolean match(char[] in) {
            if (in.length == 0) {
                return false;
            }

            if (this.element != in[0]) {
                return false;
            }

            char[] remaining = new char[in.length - 1];
            System.arraycopy(in, 1, remaining, 0, remaining.length);

            if (this.next == null) {
                return remaining.length == 0;
            }

            return this.next.match(remaining);
        }

        @Override
        public String toString() {
            return "[" + this.element + "]";
        }
    }

    static class DotNode extends Node {
        DotNode() {
        }

        @Override
        boolean match(char[] in) {
            if (in.length == 0) {
                return false;
            }

            char[] remaining = new char[in.length - 1];
            System.arraycopy(in, 1, remaining, 0, remaining.length);

            if (this.next == null) {
                return remaining.length == 0;
            }

            return this.next.match(remaining);
        }

        @Override
        public String toString() {
            return "[.]";
        }
    }

    static class StarNode extends Node {

        private final char n;

        StarNode(char n) {
            this.n = n;
        }

        @Override
        boolean match(char[] in) {
            if (this.next == null) {
                for (char c : in) {
                    if (c != this.n && this.n != '.') {
                        return false;
                    }
                }
                return true;
            }

            if (this.next.match(in)) {
                return true;
            }

            for (int i = 0; i < in.length; i++) {
                if (this.n != '.' && this.n != in[i]) {
                    break;
                }

                char[] arr = new char[in.length - (i + 1)];
                for (int x = i + 1, j = 0; x < in.length; x++, j++) {
                    char val = in[x];
                    arr[j] = val;
                }

                if (this.next.match(arr)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public String toString() {
            return "[" + this.n + "*]";
        }
    }

}
