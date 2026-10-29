class Solution {
    public static int solve(int [][]dp,int[][]grid,int m,int n,int i,int j){
        if(i>=m||j>=n){
            return Integer.MAX_VALUE;
        }
        if(i==m-1&&j==n-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int r=solve(dp,grid,m,n,i+1,j);
        int d=solve(dp,grid,m,n,i,j+1);
        return dp[i][j]= grid[i][j]+Math.min(r,d);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(dp,grid,m,n,0,0);
    }
}