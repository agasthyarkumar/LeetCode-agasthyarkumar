class Solution:
    def minHeightShelves(self, books: List[List[int]], shelfWidth: int) -> int:
        n=len(books)
        inf=10**20
        hascache=[[False]*(n+1) for _ in range(n+1)]
        cache=[[None]*(n+1) for _ in range(n+1)]
        pwidth=[[0]*(n+1) for _ in range(n+1)]
        pheight=[[0]*(n+1) for _ in range(n+1)]
        for left in range(n):
            width=0
            height=0
            for right in range(left,n):
                width+=books[right][0]
                if width>shelfWidth:
                    break
                pwidth[left][right]=width
                if books[right][1]>height:
                    height=books[right][1]
                pheight[left][right]=height
        def getmin(index,startindex):
            height=pheight[startindex][index-1]
            if index==n:
                return height
            width=pwidth[startindex][index-1]
            if hascache[startindex][index]:
                return cache[startindex][index]
            start=getmin(index+1,index)+height
            cont=inf
            if width+books[index][0]<=shelfWidth:
                cont=getmin(index+1,startindex)
            best=min(start,cont)
            hascache[startindex][index]=True
            cache[startindex][index]=best
            return best
        return getmin(1,0)
