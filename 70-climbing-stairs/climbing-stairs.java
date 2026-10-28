class Solution {
    public int climbStairs(int n) {
        // int n1=1;
        // int n2=2;
        // int k;
        // if(n<2){
        //     return n;
        // }
        // else{for(int i=3;i<=n;i++){
        //     k=n1+n2;
        //     n1=n2;
        //     n2=k;
        // }
        // }
        // return n2;
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}