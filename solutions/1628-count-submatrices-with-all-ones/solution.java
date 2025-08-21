// class Solution {
//   public int numSubmat(int[][] mat) {
//     final int m = mat.length;
//     final int n = mat[0].length;
//     int ans = 0;

//     for (int baseRow = 0; baseRow < m; ++baseRow) {
//       int[] row = new int[n];
//       Arrays.fill(row, 1);
//       for (int i = baseRow; i < m; ++i) {
//         for (int j = 0; j < n; ++j)
//           row[j] &= mat[i][j];
//         ans += count(row);
//       }
//     }

//     return ans;
//   }

//   private int count(int[] row) {
//     int res = 0;
//     int length = 0;




//     for (final int num : row) {
//       length = num == 0 ? 0 : length + 1;
//       res += length;
//     }
//     return res;
//   }
// }
class Solution {
  public int numSubmat(int[][] mat) {
    int ans = 0;
    int[] hist = new int[mat[0].length];

    for (int[] row : mat) {
      for (int i = 0; i < row.length; ++i)
        hist[i] = row[i] == 0 ? 0 : hist[i] + 1;
      ans += count(hist);
    }

    return ans;
  }

  private int count(int[] hist) {
    // submatrices[i] := the number of submatrices, where the i-th column is the
    // right border
    int[] submatrices = new int[hist.length];
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < hist.length; ++i) {
      while (!stack.isEmpty() && hist[stack.peek()] >= hist[i])
        stack.pop();
      if (!stack.isEmpty()) {
        final int prevIndex = stack.peek();
        submatrices[i] = submatrices[prevIndex] + hist[i] * (i - prevIndex);
      } else {
        submatrices[i] = hist[i] * (i + 1);
      }
      stack.push(i);
    }

    return Arrays.stream(submatrices).sum();
  }
}
