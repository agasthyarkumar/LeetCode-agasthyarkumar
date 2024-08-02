class Solution {
    public int minSwaps(int[] nums) {
        int wsize=0;
        for(int num:nums) {wsize+=num;}
        int curz=0;
        for(int i=0;i<wsize;i++)if(nums[i]==0)curz++;
        int minz=curz;
        int start=0;
        int end=wsize-1;
        int n=nums.length;
        while(start<n){
            if(nums[start]==0){curz--;}
            start++;
            end++;
            if(nums[end%n]==0){curz++;}
            minz=Math.min(minz,curz);
        }
        return minz;
    }
}
