class Solution {
    public int smallestNumber(int n, int t) {
        int res = n;
        if(prod(n)%t == 0) return n;
        else{
            int temp=n;
            while(prod(temp)%t != 0) temp++;
            return temp;
        }
    }
    private int prod(int p) {
        int res=1;
        while(p!=0){
            res*=p%10;
            p=p/10;
        }   
        return res; 

    }
}
