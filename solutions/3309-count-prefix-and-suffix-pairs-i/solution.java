import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Integer, TrieNode> children = new HashMap<>();
    int count = 0; // Tracks how many times this node is visited
}

class Trie {
    private TrieNode root = new TrieNode();

    public int insert(final String word) {
        final int n = word.length();
        int pairCount = 0;
        TrieNode node = root;

        for (int i = 0; i < n; ++i) {
            final char prefix = word.charAt(i); // Current prefix character
            final char suffix = word.charAt(n - 1 - i); // Current suffix character
            final int key = (prefix - 'a') * 26 + (suffix - 'a'); // Unique key for prefix-suffix pair

            // Add node if not already present
            node.children.putIfAbsent(key, new TrieNode());
            node = node.children.get(key);

            // Count how many pairs can be formed at this node
            pairCount += node.count;
        }

        // Increment the count of this word ending here
        ++node.count;
        return pairCount;
    }
}

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        long totalPairs = 0; // Use long for intermediate calculations to avoid overflow
        Trie trie = new Trie();

        // Insert each word into the Trie and accumulate the pair counts
        for (final String word : words) {
            totalPairs += trie.insert(word);
        }

        // Explicitly cast to int before returning
        return (int) totalPairs;
    }
}

