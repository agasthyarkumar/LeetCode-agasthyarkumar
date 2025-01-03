/*class Solution {
    public int waysToSplitArray(int[] nums) {
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(sum(Arrays.copyOfRange(nums,0,i))>=sum(Arrays.copyOfRange(nums,i,n))){
                ++ans;
            }
        }
        return ans;        
    }
    private int sum(int[] nm){
        int s=0;
        for(int a:nm){
            s+=a;
        }
        return s;
    }
}*/
//*
class Solution {
    public int waysToSplitArray(int[] nums) {
        int ans = 0;
        int n = nums.length;

        // Calculate the total sum of the array
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        long leftSum = 0;
        // Iterate through the array (excluding the last element for valid split)
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            long rightSum = totalSum - leftSum;
            if (leftSum >= rightSum) {
                ans++;
            }
        }

        return ans;
    }
}
// */
