package secondRound.Week6.第13课_字典树和并查集;

public class L208_Implement_Trie_or_Prefix_Tree {
    class Trie {
        class TrieNode {
            boolean isEnd;
            TrieNode[] next;

            public TrieNode() {
                isEnd = false;
                next = new TrieNode[26];
            }
        }

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }


        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode p = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (p.next[index] == null) {
                    p.next[index] = new TrieNode();
                }
                p = p.next[index];
            }
            p.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (cur.next[index] == null) {
                    return false;
                }
                cur = cur.next[index];
            }
            return cur.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (cur.next[index] == null) {
                    return false;
                }
                cur = cur.next[index];
            }
            return true;
        }
    }

}
