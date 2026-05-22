class Solution {
    private static final int MOD = 1000000007;

    public int numberOfRoutes(String[] grid, int d) {
        int n = grid.length, m = grid[0].length(), k = (int) Math.sqrt(d * d - 1);
        long[] prefix = new long[m + 1], dp = new long[m + 1];
        for (int i = 0; i < n; i++) {
            if (grid[i].indexOf('.') == -1)
                return 0;
            char[] arr = grid[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (arr[j] == '#')
                    prefix[j + 1] = prefix[j];
                else if (i == 0)
                    prefix[j + 1] = prefix[j] + 1;
                else
                    prefix[j + 1] = prefix[j] + dp[Math.min(j + k, m - 1) + 1] - dp[Math.max(j - k, 0)];
            }
            for (int j = 0; j < m; j++)
                dp[j + 1] = arr[j] == '#' ? dp[j]
                        : (dp[j] + prefix[Math.min(j + d, m - 1) + 1] - prefix[Math.max(j - d, 0)]) % MOD;
        }
        return (int) ((dp[m] + MOD) % MOD);
    }
}
