// class Solution {
//     public boolean checkOnesSegment(String s) {
//         // boolean res=true;
//         int count=countones(s);
//         for(int i=0;i<s.length();i++){
//             if(s.charAt(i)=='1')
//             for(int j=i;j<count;j++)
//             if(s.charAt(j)=='0')return false;
//         }
//         return true;
        
//     }
//     private int countones(String s){
//         int count=0;
//         for(int i=0;i<s.length();i++)if(s.charAt(i)=='1')count++;
//         return count;
//     }
// }
class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
