import java.util.*;

class Solution {
  public int minTimeToReach(int[][] moveTime) {
    final int[][] DIRS = {{0,1},{1,0},{0,-1},{-1,0}};
    final int m = moveTime.length;
    final int n = moveTime[0].length;
    int[][] dist = new int[m][n];
    for (int[] row : dist)
      Arrays.fill(row, Integer.MAX_VALUE);

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    dist[0][0] = 0;
    pq.offer(new int[]{0, 0, 0}); // {distance, x, y}

    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int d = curr[0], i = curr[1], j = curr[2];
      if (i == m-1 && j == n-1) return d;
      if (d > dist[i][j]) continue;

      int parity = (i + j) % 2 + 1;
      for (int[] dir : DIRS) {
        int x = i + dir[0], y = j + dir[1];
        if (x < 0 || x >= m || y < 0 || y >= n) continue;
        int newDist = Math.max(moveTime[x][y], d) + parity;
        if (newDist < dist[x][y]) {
          dist[x][y] = newDist;
          pq.offer(new int[]{newDist, x, y});
        }
      }
    }
    return -1;
  }
}

