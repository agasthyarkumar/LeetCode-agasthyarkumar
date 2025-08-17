class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k - 1 + maxPts)
            return 1.0;
        if (n < k)
            return 0.0;
        double[] d = new double[n + 1];
        for (int i = 1; i <= n; i++){
            d[i] = 1.0;
        }
        int right = Math.min(n, k + maxPts - 1);
        double window = 0.0;
        for (int i = k; i <= right; i++){
            window += d[i];
        }
        for (int i = k - 1; i >= 0; i--){
            d[i] = window / maxPts;
            window += d[i];
            if (i + maxPts <= n)
                window -= d[i + maxPts];
        }
        return d[0];
    }
}
