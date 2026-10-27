class Solution {
    public void rec(List<List<Integer>> r,int[] nums,List<Integer> temp,int j){
        r.add( new ArrayList<Integer>(temp));
        for(int i=j;i<nums.length;i++){
            temp.add(nums[i]);
            rec(r,nums,temp,i+1);
            temp.remove(temp.size()-1);

        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> r=new ArrayList<>();
        rec(r,nums,new ArrayList<Integer>(),0);
        return r;
    }
}