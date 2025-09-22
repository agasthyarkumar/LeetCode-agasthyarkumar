class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        arr=[0]*101
        for i in nums:
            arr[i]= arr[i]+1
        maxfreq=max(arr)
        total=0
        for i in arr:
            if maxfreq==i:
                total=total+i
        return total
