class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
       int f[]=new int[1001];
        for(int element: target)f[element]++;
        for(int element: arr)f[element]--;
        for(int element: f)if(element!=0) return false;
        return true; 
    }
}
