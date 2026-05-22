class Solution {
    public int[] findDegrees(int[][] matrix) {
        int result[] = new int[matrix[0].length];
        for ( int i = 0 ; i < matrix[0].length ; i++ ) result[i] += sum(matrix[i]);
        return result;
    }
    private int sum(int[] matrix){
        int result = 0;
        for(int a : matrix ) result += a;
        return result;
    }
}


