class Solution {
  public int maxScoreSightseeingPair(int[] values) {
    int ans = 0;
    int bestPrev = 0;

    for (int value : values) {
      ans = Math.max(ans, value + bestPrev);
      bestPrev = Math.max(bestPrev, value) - 1;
    }

    return ans;
  }
}
