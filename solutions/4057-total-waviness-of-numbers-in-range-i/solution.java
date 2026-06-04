class Solution {

    static class Pair {
        long count;
        long waviness;

        Pair(long count, long waviness) {
            this.count = count;
            this.waviness = waviness;
        }
    }

    private String s;
    private Pair[][][][][] memo;

    public int totalWaviness(int num1, int num2) {
        return (int) (solve(num2) - solve(num1 - 1));
    }

    private long solve(int n) {
        if (n <= 0) return 0;

        s = String.valueOf(n);
        int len = s.length();

        memo = new Pair[len][2][2][11][11];

        return dfs(0, 1, 0, 10, 10).waviness;
    }

    private Pair dfs(int pos, int tight, int started, int prev2, int prev1) {
        if (pos == s.length()) {
            return new Pair(1, 0);
        }

        if (memo[pos][tight][started][prev2][prev1] != null) {
            return memo[pos][tight][started][prev2][prev1];
        }

        int limit = (tight == 1) ? s.charAt(pos) - '0' : 9;

        long totalCount = 0;
        long totalWaviness = 0;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {
                Pair next = dfs(pos + 1, newTight, 0, 10, 10);

                totalCount += next.count;
                totalWaviness += next.waviness;
            } else {

                int add = 0;

                // We have three consecutive digits: prev2, prev1, d
                if (started == 1 && prev2 != 10) {
                    if ((prev1 > prev2 && prev1 > d) ||
                        (prev1 < prev2 && prev1 < d)) {
                        add = 1;
                    }
                }

                int nextPrev2, nextPrev1;

                if (started == 0) {
                    nextPrev2 = 10;
                    nextPrev1 = d;
                } else if (prev2 == 10) {
                    nextPrev2 = prev1;
                    nextPrev1 = d;
                } else {
                    nextPrev2 = prev1;
                    nextPrev1 = d;
                }

                Pair next = dfs(
                    pos + 1,
                    newTight,
                    1,
                    nextPrev2,
                    nextPrev1
                );

                totalCount += next.count;
                totalWaviness += next.waviness + next.count * add;
            }
        }

        return memo[pos][tight][started][prev2][prev1] =
            new Pair(totalCount, totalWaviness);
    }
}
