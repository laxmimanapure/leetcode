class Solution {
    public static int solve(int[][] dp,int[][] matrix,int m,int n,int i,int j){
        if(j>=n||j<0){
            return Integer.MAX_VALUE;
        }
        if(i==m-1){
            return matrix[i][j];
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        int tr=solve(dp,matrix,m,n,i+1,j-1);
        int d=solve(dp,matrix,m,n,i+1,j);
        int dr=solve(dp,matrix,m,n,i+1,j+1);
        return dp[i][j]=matrix[i][j]+Math.min(tr,Math.min(dr,d));
    }
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int min=Integer.MAX_VALUE;
        int dp[][]=new int[m][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            min=Math.min(min,solve(dp,matrix,m,n,0,i));

        }
        return min;
    }
}