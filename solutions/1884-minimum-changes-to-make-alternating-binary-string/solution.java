class Solution {
    public int minOperations(String s) {
        int startWith0 = 0;
        int startWith1 = 0;

        for (int i = 0; i < s.length(); i++) {
            char expected0 = (i % 2 == 0) ? '0' : '1';
            char expected1 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expected0) startWith0++;
            if (s.charAt(i) != expected1) startWith1++;
        }

        return Math.min(startWith0, startWith1);
    }
}


// class Solution {
//     public int minOperations(String s) {
//         int res=0;
//         if(s.length()%2==0 && isValid(s))return s.length()/2;
//         for (int i=0;i<s.length()-1;i++)
//         if(s.charAt(i)==s.charAt(i+1))res++;
//         return Math.min(res,count1(s));
//     }
//     private boolean isValid(String s){
//         for (int i=0;i<s.length();i++){
//         if (s.charAt(0)==s.charAt(i)) continue;
//         else return false;
//         }
//         return true;

//     }
//     private int count1 (String s) {
//         int count=0;
//         for(int i=0;i<s.length();i++)
//         if(s.charAt(i)=='1')count++;
//         return s.length()-count;
//     }
// }

// // class Solution {
// //      public int minOperations(String s) {
// //         int count=0;
// //         for(int i=0;i<s.length();i++)
// //         if(s.charAt(i)=='1')count++;
// //         return s.length()-count;
// //     }
// // }

