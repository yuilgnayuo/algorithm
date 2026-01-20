package algo.zuo.code44;

import java.util.HashMap;

// 用类描述实现前缀树。不推荐！
// 测试链接 : https://leetcode.cn/problems/implement-trie-ii-prefix-tree/
public class Code01_TrieTree {

    // 使用类数组来表示
    class Trie1 {
        class TrieNode {
            public int pass; // 路过多少？
            public int end; // 有多少个结尾的字符
            public TrieNode[] nexts;

            public TrieNode() {
                pass = 0;
                end = 0;
                nexts = new TrieNode[26];
            }
        }

        private TrieNode root;

        public Trie1() {
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

        // 如果之前word插入过前缀树，那么此时删掉一次
        // 如果之前word没有插入过前缀树，那么什么也不做
        public void erase(String word) {
            if (countWordEqualTo(word) > 0) {
                TrieNode node = root;
                node.pass--;
                for (int i = 0, path; i < word.length(); i++) {
                    path = word.charAt(i) - 'a';
                    if (--node.nexts[path].pass == 0) {
                        node.nexts[path] = null;
                        return;
                    }
                    node = node.nexts[path];
                }
                node.end--;
            }
        }

        // 前缀树中有多少个 word
        private int countWordEqualTo(String word) {
            TrieNode node = root;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.end;
        }

        // 有多少个字符是以 pre 为前缀的
        public int countWordsStartingWith(String pre) {
            TrieNode node = root;
            for (int i = 0, path; i < pre.length(); i++) {
                path = pre.charAt(i) - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.pass;
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

    // 使用hash 表来表示
    class Trie2 {
        class TrieNode {
            public int pass; // 路过多少？
            public int end; // 有多少个结尾的字符
            HashMap<Integer, TrieNode> nexts;

            public TrieNode() {
                pass = 0;
                end = 0;
                nexts = new HashMap<>();
            }
        }

        private TrieNode root;

        public Trie2() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            node.pass++;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (!node.nexts.containsKey(path)) {
                    node.nexts.put(path, new TrieNode());
                }
                node = node.nexts.get(path);
                node.pass++;
            }
            node.end++;
        }

        // 如果之前word插入过前缀树，那么此时删掉一次
        // 如果之前word没有插入过前缀树，那么什么也不做
        public void erase(String word) {
            if (countWordEqualTo(word) > 0) {
                TrieNode node = root;
                node.pass--;
                for (int i = 0, path; i < word.length(); i++) {
                    path = word.charAt(i) - 'a';
                    if (--node.nexts.get(path).pass == 0) {
                        node.nexts.remove(path);
                        return;
                    }
                    node = node.nexts.get(path);
                }
                node.end--;
            }
        }

        private int countWordEqualTo(String word) {
            TrieNode node = root;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (!node.nexts.containsKey(path)) return 0;
                node = node.nexts.get(path);
            }
            return node.end;
        }

        public int countWordsStartingWith(String pre) {
            TrieNode node = root;
            for (int i = 0, path; i < pre.length(); i++) {
                path = pre.charAt(i) - 'a';
                if (!node.nexts.containsKey(path)) return 0;
                node = node.nexts.get(path);
            }
            return node.pass;
        }
    }
}
