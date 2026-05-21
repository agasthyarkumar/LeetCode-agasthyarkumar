class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[10];
    }
    TrieNode root = new TrieNode();
    private void insert(int num) {

        char[] arr = String.valueOf(num).toCharArray();

        TrieNode node = root;

        for (char c : arr) {

            int idx = c - '0';

            if (node.child[idx] == null) {
                node.child[idx] = new TrieNode();
            }

            node = node.child[idx];
        }
    }
    private int findPrefix(int num) {

        char[] arr = String.valueOf(num).toCharArray();
        TrieNode node = root;
        int len = 0;
        for (char c : arr) {
            int idx = c - '0';
            if (node.child[idx] == null) {
                break;
            }
            len++;
            node = node.child[idx];
        }
        return len;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        for (int num : arr1) {
            insert(num);
        }
        int ans = 0;
        for (int num : arr2) {
            ans = Math.max(ans, findPrefix(num));
        }

        return ans;
    }
}
