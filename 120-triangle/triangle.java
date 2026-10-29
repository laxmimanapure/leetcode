class Solution {
    public static int solve(int dp[][],List<List<Integer>> triangle,int m,int n,int i,int j){
        // if(i>=m||j>=n){
        //     return 0;
        // }
        // if(i==m-1||j==n-1){
        //     return triangle.get(i).get(j);
        // }
        // int d=solve(triangle,m,n,i+1,j);
        // int sd=solve(triangle,m,n,i+1,j+1);
        // return triangle.get(i).get(j)+Math.min(d,sd);
        if(i>=m||j>=n){
            return 0;
        }
        if(i==m-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
              return dp[i][j];
       }

        int d=solve(dp,triangle,m,n,i+1,j);
        int sd=solve(dp,triangle,m,n,i+1,j+1);
        return dp[i][j]= triangle.get(i).get(j)+Math.min(d,sd);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int dp[][]=new int[m][m];
        for(int i=0;i<m;i++){
            // for(int j=0;j<triangle.get(i).size();j++)
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return solve(dp,triangle,m,m,0,0);
    }
}