class Solution {
    public int countPartitions(int[] nums) {
        int t=0;
        for(int i=0;i<nums.length;i++){
            t+=nums[i];
        }
        int a=0;
        int left=0;
        for(int i=0;i<nums.length-1;i++){
             left+=nums[i];
             int right=t-left;
             int dif=right-left;
             if(dif%2==0){
                a++;
             }
        }
        return a;
    }
}