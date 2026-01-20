package algo.leetcode;

// https://leetcode.cn/problems/implement-trie-prefix-tree/
public class P208_Trie {
    static class Trie {

        static class TrieNode {
            public int pass;
            public int end;
            public TrieNode[] nexts;

            public TrieNode() {
                pass = 0;
                end = 0;
                nexts = new TrieNode[26];
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            node.pass++;
            char[] chars = word.toCharArray();
            for (int i = 0, path; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (node.nexts[path] == null) {
                    node.nexts[path] = new TrieNode();
                }
                // 获取下一个位置
                node = node.nexts[path];
                node.pass++;
            }
            node.end++;
        }

        public boolean search(String word) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (int i = 0, path; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (node.nexts[path] == null) {
                    return false;
                }
                // 获取下一个位置
                node = node.nexts[path];
            }
            return node.end > 0;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            char[] chars = prefix.toCharArray();
            for (int i = 0, path; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (node.nexts[path] == null) {
                    return false;
                }
                // 获取下一个位置
                node = node.nexts[path];
            }
            return true;
        }
    }

}
