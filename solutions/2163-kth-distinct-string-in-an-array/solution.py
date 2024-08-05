class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        lookup={x:index for index,x in enumerate(arr)}
        count=0
        for key,v in sorted(collections.Counter(arr).items(),key=lambda x:lookup[x[0]]):
            if v==1:
                count+=1
            if count==k:
                return key
        return ""
