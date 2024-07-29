from sortedcontainers import SortedList
class Solution:
    def numTeams(self, rating: List[int]) -> int:
        n=len(rating)
        def get(rating):
            small=[]
            seen=SortedList()
            for x in rating:
                small.append(seen.bisect_left(x))
                seen.add(x)
            return small
        small_left=get(rating)
        small_right=get(rating[::-1])[::-1]
        def gett(small_left,small_right):
            total=0
            for j in range(n):
                left_small=small_left[j]
                right_big=(n-j-1)-small_right[j]
                total+=left_small*right_big
            return total
        return gett(small_left,small_right)+gett(small_right[::-1],small_left[::-1])  
