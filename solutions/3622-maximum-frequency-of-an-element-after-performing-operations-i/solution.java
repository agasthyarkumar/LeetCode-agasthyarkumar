import java.util.*;

class Solution {
  public int maxFrequency(int[] nums, int k, int numOperations) {
    int n = nums.length;
    if (n == 0) return 0;
    // Maps to count exact occurrences of original numbers
    HashMap<Long, Integer> exactCount = new HashMap<>(n * 2);

    // Collect all candidate coordinates: start = num - k, end = num + k + 1, and the exact num
    // Use long for coordinates to avoid overflow with large k
    ArrayList<Long> coords = new ArrayList<>(n * 3);
    for (int v : nums) {
      long num = v;
      exactCount.put(num, exactCount.getOrDefault(num, 0) + 1);
      coords.add(num);
      coords.add(num - k);
      coords.add(num + (long)k + 1L);
    }

    // Unique sort
    Collections.sort(coords);
    ArrayList<Long> uniq = new ArrayList<>(coords.size());
    long prev = Long.MIN_VALUE;
    for (long x : coords) {
      if (x != prev) {
        uniq.add(x);
        prev = x;
      }
    }
    int m = uniq.size();

    // Map coordinate -> index
    HashMap<Long, Integer> idxMap = new HashMap<>(m * 2);
    for (int i = 0; i < m; ++i) idxMap.put(uniq.get(i), i);

    // Difference array for ranges
    int[] diff = new int[m + 1]; // extra slot to avoid bounds checks on decrement
    for (int v : nums) {
      long start = v - (long)k;
      long endEx = v + (long)k + 1L; // exclusive end
      int si = idxMap.get(start);
      int ei = idxMap.get(endEx);
      diff[si] += 1;
      diff[ei] -= 1;
    }

    // Prefix sum -> adjustable counts at each compressed coordinate
    int[] adjustable = new int[m];
    int cur = 0;
    for (int i = 0; i < m; ++i) {
      cur += diff[i];
      adjustable[i] = cur;
    }

    // Compute exact counts per compressed coordinate
    int[] exactAt = new int[m];
    for (Map.Entry<Long, Integer> e : exactCount.entrySet()) {
      long val = e.getKey();
      int c = e.getValue();
      Integer id = idxMap.get(val);
      if (id != null) exactAt[id] = c;
    }

    // Evaluate best answer
    int ans = 0;
    for (int i = 0; i < m; ++i) {
      int cnt = exactAt[i];
      int adj = adjustable[i];
      int others = adj - cnt;
      if (others < 0) others = 0;
      int take = Math.min(numOperations, others);
      ans = Math.max(ans, cnt + take);
    }

    // Edge: if no exact matched coordinate was in uniq (shouldn't happen) ensure at least 1 if nums non-empty
    return Math.max(ans, n == 0 ? 0 : 1);
  }
}

