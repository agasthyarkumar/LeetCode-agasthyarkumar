class Solution:
    def minimumDeletions(self, s: str) -> int:
        n=len(s)
        lb=0
        ra=s.count("a")
        best=ra
        for i in range(n):
            if s[i]=='b':
                lb+=1
            else:
                ra-=1
            best=min(best,lb+ra)
        return best


