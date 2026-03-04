class Solution {
    public int numSpecial(int[][] mat) {
    int count=0;
      for(int i = 0 ; i < mat.length ; i++)
      for(int j = 0 ; j < mat[0].length ; j++)
      if ((mat[i][j]==1) && isValid(mat,i,j)) count++;
      return count;
    }
    private boolean isValid(int[][] mat, int i, int j){
        for(int a=0;a<mat.length;a++)if(i!=a && mat[a][j]==1)return false;
        for(int a=0;a<mat[0].length;a++)if(j!=a && mat[i][a]==1)return false;
        return true;
    }
}
