class Solution:
    def rangeSum(self, nums: List[int], n: int, left: int, right: int) -> int:
        mod=10**9+7
        a=[]
        for i in range(n):
            c=0
            for j in range(i,n):
                c+=nums[j]
                a.append(c)
        a.sort()
        return sum(a[(left-1):right])%mod
