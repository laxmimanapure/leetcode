class Solution {
    public static int solve(int[][] dp,int m,int n,int i,int j){
        // if(i>=m||j>=n){
        //     return 0;
        // }
        // if(i==m-1&&j==n-1){
        //     return 1;
        // }
        // int left=solve(m,n,i+1,j);
        // int bottom=solve(m,n,i,j+1);
        // return left+bottom;
         if(i>=m||j>=n){
            return 0;
        }
        if(i==m-1&&j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left=solve(dp,m,n,i+1,j);
        int bottom=solve(dp,m,n,i,j+1);
        return dp[i][j]=left+bottom;

    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(dp,m,n,0,0);
    }
}