class Solution {
  public int countPalindromicSubsequence(String s) {
    int ans = 0;
    int n = s.length();
    int[] first = new int[26];
    int[] last = new int[26];
    boolean[][] seen = new boolean[26][26];

    // Initialize first and last occurrence arrays
    Arrays.fill(first, -1);

    for (int i = 0; i < n; ++i) {
      int index = s.charAt(i) - 'a';
      if (first[index] == -1)
        first[index] = i;
      last[index] = i;
    }

    // For each character as the outer character of a palindrome
    for (int i = 0; i < 26; ++i) {
      if (first[i] < last[i]) {
        int left = first[i] + 1;
        int right = last[i];
        
        // Track characters between first[i] and last[i]
        boolean[] innerChars = new boolean[26];
        for (int j = left; j < right; ++j) {
          int innerChar = s.charAt(j) - 'a';
          if (!innerChars[innerChar]) {
            innerChars[innerChar] = true;
            if (!seen[i][innerChar]) {
              seen[i][innerChar] = true;
              ++ans;
            }
          }
        }
      }
    }

    return ans;
  }
}

