# class Solution:
#     def missingMultiple(self, nums: List[int], k: int) -> int:
#         nums.sort()
#         res=[]
#         for i in nums:
#             if i%k == 0:
#                 res.append(i)
#         print(res)
#         if len(res) == 0 or res[0] > k:
#             return k
#         for i in range(len(res)):
#             if res[i]+k != res[i+1]:
#                 return res[i]+k

class Solution:
    def missingMultiple(self, nums: List[int], k: int) -> int:
        nums_set = set(nums)

        multiple = k

        while multiple in nums_set:
            multiple += k

        return multiple
