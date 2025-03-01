class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1]=0;
            }
            else continue;
        }
        int i=0;;
        int[] ans = new int[nums.length];
        for(int a:nums)
            if(a>0)
                ans[i++]=a;
        
        return ans;
    }
}

