package answer.leetcode;

import java.util.HashMap;
import java.util.Map;

class LeetCode208 {
    private class Node {
        public boolean isWord = false;
        public Map<Character, Node> next = new HashMap<>();

        Node() {

        }

        Node(boolean word) {
            isWord = word;
        }
    }

    int size;
    Node root;

    /**
     * Initialize your data structure here.
     */
    public LeetCode208() {
        size = 0;
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node now = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!now.next.containsKey(c)) {
                now.next.put(c, new Node());
            }
            now = now.next.get(c);
        }
        if (!now.isWord) {
            now.isWord = true;
            size++;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node now = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!now.next.containsKey(c)) {
                return false;
            }
            now = now.next.get(c);
        }
        return now.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node now = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!now.next.containsKey(c)) {
                return false;
            }
            now = now.next.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode208 l = new LeetCode208();
        l.insert("apple");
        l.insert("appel");
        l.insert("bull");
        System.out.println(l.search("apple"));
        System.out.println(l.startsWith("app"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */