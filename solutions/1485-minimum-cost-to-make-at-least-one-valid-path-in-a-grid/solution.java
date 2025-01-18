class Solution {
  public int minCost(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] mem = new int[m][n];
    for (int[] row : mem) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }

    Deque<int[]> deque = new ArrayDeque<>();
    deque.offerFirst(new int[]{0, 0, 0}); // {i, j, cost}
    mem[0][0] = 0;

    // Directions: right, left, down, up
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    while (!deque.isEmpty()) {
      int[] curr = deque.pollFirst();
      int i = curr[0], j = curr[1], cost = curr[2];

      // Skip if already visited with a cheaper cost
      if (cost > mem[i][j]) continue;

      // Try all four directions
      for (int d = 0; d < 4; ++d) {
        int ni = i + dirs[d][0], nj = j + dirs[d][1];
        int newCost = cost + (grid[i][j] == d + 1 ? 0 : 1); // No cost if it's the correct direction

        if (ni >= 0 && ni < m && nj >= 0 && nj < n && newCost < mem[ni][nj]) {
          mem[ni][nj] = newCost;
          if (grid[i][j] == d + 1) {
            deque.offerFirst(new int[]{ni, nj, newCost}); // Prioritize zero-cost moves
          } else {
            deque.offerLast(new int[]{ni, nj, newCost});
          }
        }
      }
    }

    return mem[m - 1][n - 1];
  }
}

