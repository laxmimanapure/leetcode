class Solution {
    public static int solve(int dp[][],int[][]ob,int m,int n,int i,int j){
        // if(i>=m||j>=n){
        //     return 0;

        // }
        // if(ob[i][j]==1){
        //     return 0;
        // }
        // if(i==m-1&&j==n-1){
        //     return 1;
        // }
        // int r=solve(ob,m,n,i+1,j);
        // int d=solve(ob,m,n,i,j+1);
        // return r+d;
        if(i>=m||j>=n){
            return 0;

        }
        if(ob[i][j]==1){
            return 0;
        }
        if(i==m-1&&j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int r=solve(dp,ob,m,n,i+1,j);
        int d=solve(dp,ob,m,n,i,j+1);
        return dp[i][j]=r+d;


    }
    public int uniquePathsWithObstacles(int[][] ob) {
        int m=ob.length;
        int n=ob[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(dp,ob,m,n,0,0);
    }
}