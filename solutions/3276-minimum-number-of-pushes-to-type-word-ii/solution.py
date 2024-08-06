class Solution:
    def minimumPushes(self, word: str) -> int:
        v=sorted(collections.Counter(word).values(),reverse=True)
        t=0
        for i,j in enumerate(v):
            t+=j*(i//8+1)
        return t
        
