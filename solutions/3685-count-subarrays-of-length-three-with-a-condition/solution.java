class Solution {
    int count=0;
    public int countSubarrays(int[] nums) {
        valid(nums,1);
        return count;
    }
    void valid(int arr[],int i){
        if(i+1>=arr.length)return;
        if(arr[i]==2*(arr[i-1]+arr[i+1]))count++;
        valid(arr,i+1);
    }
}
