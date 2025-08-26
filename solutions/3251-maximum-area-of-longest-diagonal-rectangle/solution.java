class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiag = -1, maxArea = -1;

        for (int[] d : dimensions) {
            int a = d[0], b = d[1];
            int diag = a * a + b * b;
            int area = a * b;

            // Condition: better if (diag > maxDiag) OR (diag == maxDiag && area > maxArea)
            int cmp1 = Integer.compare(diag, maxDiag);   // >0 if diag > maxDiag, <0 if less, 0 if equal
            int cmp2 = Integer.compare(area, maxArea);   // same idea for area

            // Better if cmp1 > 0, OR (cmp1 == 0 and cmp2 > 0)
            int better = ((cmp1 > 0) | ((cmp1 == 0) & (cmp2 > 0))) ? 1 : 0;

            // Mask update: either keep old values or replace with new
            maxDiag = better * diag + (1 - better) * maxDiag;
            maxArea = better * area + (1 - better) * maxArea;
        }

        return maxArea;
    }
}

