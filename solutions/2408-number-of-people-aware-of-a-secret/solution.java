// class Solution {
//   public int peopleAwareOfSecret(int n, int delay, int forget) {
//     final int MOD = 1_000_000_007;
//     long share = 0;
//     int[] dp = new int[n];
//     dp[0] = 1;
//     for (int i = 1; i < n; ++i) {
//       if (i - delay >= 0)
//         share += dp[i - delay];
//       if (i - forget >= 0)
//         share -= dp[i - forget];
//       share += MOD;
//       share %= MOD;
//       dp[i] = (int) share;
//     }
//     int ans = 0;
//     for (int i = n - forget; i < n; ++i)
//       ans = (ans + dp[i]) % MOD;
//     return ans;
//   }
// }

class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1_000_000_007;
        
        long[] dp = new long[n + 1]; // dp[i] = number of people who learn the secret on day i
        dp[1] = 1;
        long share = 0; // number of people who can share today
        
        for (int day = 2; day <= n; day++) {
            // People start sharing after "delay" days
            if (day - delay >= 1) {
                share = (share + dp[day - delay]) % MOD;
            }
            // People forget after "forget" days
            if (day - forget >= 1) {
                share = (share - dp[day - forget] + MOD) % MOD;
            }
            dp[day] = share;
        }
        
        long ans = 0;
        // Sum people who still remember at day n
        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) ans = (ans + dp[day]) % MOD;
        }
        return (int) ans;
    }
}

