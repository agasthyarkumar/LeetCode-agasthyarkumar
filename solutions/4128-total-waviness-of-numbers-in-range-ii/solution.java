class Solution {

    static class Pair {
        long count;
        long waviness;

        Pair(long count, long waviness) {
            this.count = count;
            this.waviness = waviness;
        }
    }

    private char[] digits;
    private Pair[][][][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n < 0) return 0;

        digits = String.valueOf(n).toCharArray();

        memo = new Pair[digits.length][2][2][3][11][11];

        return dfs(0, 1, 0, 0, 10, 10).waviness;
    }

    private Pair dfs(
            int pos,
            int tight,
            int started,
            int state,
            int prev2,
            int prev1
    ) {
        if (pos == digits.length) {
            return new Pair(1, 0);
        }

        if (tight == 0 &&
            memo[pos][tight][started][state][prev2][prev1] != null) {
            return memo[pos][tight][started][state][prev2][prev1];
        }

        int limit = tight == 1 ? digits[pos] - '0' : 9;

        long totalCount = 0;
        long totalWaviness = 0;

        for (int d = 0; d <= limit; d++) {

            int nextTight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {

                Pair nxt = dfs(
                        pos + 1,
                        nextTight,
                        0,
                        0,
                        10,
                        10
                );

                totalCount += nxt.count;
                totalWaviness += nxt.waviness;
                continue;
            }

            if (started == 0) {

                Pair nxt = dfs(
                        pos + 1,
                        nextTight,
                        1,
                        1,
                        10,
                        d
                );

                totalCount += nxt.count;
                totalWaviness += nxt.waviness;

            } else if (state == 1) {

                Pair nxt = dfs(
                        pos + 1,
                        nextTight,
                        1,
                        2,
                        prev1,
                        d
                );

                totalCount += nxt.count;
                totalWaviness += nxt.waviness;

            } else {

                int add = 0;

                if ((prev1 > prev2 && prev1 > d) ||
                    (prev1 < prev2 && prev1 < d)) {
                    add = 1;
                }

                Pair nxt = dfs(
                        pos + 1,
                        nextTight,
                        1,
                        2,
                        prev1,
                        d
                );

                totalCount += nxt.count;
                totalWaviness += nxt.waviness + (long) add * nxt.count;
            }
        }

        Pair res = new Pair(totalCount, totalWaviness);

        if (tight == 0) {
            memo[pos][tight][started][state][prev2][prev1] = res;
        }

        return res;
    }
}
