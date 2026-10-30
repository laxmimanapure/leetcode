class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length][nums.length+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(dp,nums,0,-1);
    }
    public static int solve(int[][] dp,int[] nums,int curr,int prev){

        if(curr>=nums.length){
            return 0;
        }
        if(dp[curr][prev+1]!=-1){
            return dp[curr][prev+1];
        }
        int take=0;

        if(prev==-1||nums[curr]>nums[prev]){
            take= 1+solve(dp,nums,curr+1,curr);
        }
        int nottake= solve(dp,nums,curr+1,prev);
        return dp[curr][prev+1]=Math.max(take,nottake);
    }
}