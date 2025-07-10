class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        // 1) build gaps array of length n+1
        int[] gaps = new int[n + 1];
        gaps[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];

        // 2) build suffix max array in-place
        //    suffixMax[i] = max(gaps[i], gaps[i+1], ..., gaps[n])
        int[] suffixMax = new int[n + 2];  // one extra to simplify bounds
        for (int i = n; i >= 0; i--) {
            suffixMax[i] = Math.max(gaps[i], suffixMax[i + 1]);
        }

        // 3) sweep forward, keeping track of prefix max and computing answer
        int ans = 0;
        int prefixMax = 0;  // max over gaps[0..i-1]
        for (int i = 0; i < n; i++) {
            int currMeeting = endTime[i] - startTime[i];
            int twoSides = gaps[i] + gaps[i + 1];
            // best free time elsewhere if we moved this meeting
            int elsewhere = Math.max(prefixMax, suffixMax[i + 2]);
            // if we can fit this meeting into the best other spot, we gain its length
            int candidate = twoSides + (currMeeting <= elsewhere ? currMeeting : 0);
            ans = Math.max(ans, candidate);
            // update prefix max for next iteration
            prefixMax = Math.max(prefixMax, gaps[i]);
        }

        return ans;
    }
}

