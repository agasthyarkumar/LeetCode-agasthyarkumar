class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int[][] prev = new int[n][k + 1];
        int[][] curr = new int[n][k + 1];

        for (int j = 0; j < n; j++) {
            for (int c = 0; c <= k; c++) {
                prev[j][c] = -1;
                curr[j][c] = -1;
            }
        }

        int startCost = (grid[0][0] == 0) ? 0 : 1;
        if (startCost <= k) {
            prev[0][startCost] = grid[0][0];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    curr[j][c] = -1;
                }
            }

            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {

                    int val = (i == 0) ? prev[j][c] : prev[j][c];
                    if (val == -1) continue;
                    if (i + 1 < m) {
                        int cost = (grid[i + 1][j] == 0) ? 0 : 1;
                        int newCost = c + cost;

                        if (newCost <= k) {
                            curr[j][newCost] = Math.max(
                                curr[j][newCost],
                                val + grid[i + 1][j]
                            );
                        }
                    }

                    // move right (within same row)
                    if (j + 1 < n) {
                        int cost = (grid[i][j + 1] == 0) ? 0 : 1;
                        int newCost = c + cost;

                        if (newCost <= k) {
                            prev[j + 1][newCost] = Math.max(
                                prev[j + 1][newCost],
                                val + grid[i][j + 1]
                            );
                        }
                    }
                }
            }


            if (i + 1 < m) {
                int[][] temp = prev;
                prev = curr;
                curr = temp;
            }
        }
        int ans = -1;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, prev[n - 1][c]);
        }
        return ans;
    }
}
