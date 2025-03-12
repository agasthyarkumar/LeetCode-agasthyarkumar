class Solution {
    public int maximumCount(int[] nums) {
        int p=0,n=0;
        for(int a:nums){
            if(a>0)p++;
            if(a<0)n++;
        }
        return Math.max(p,n);
    }
}
