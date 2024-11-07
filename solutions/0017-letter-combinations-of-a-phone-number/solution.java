import java.util.*;
class Solution {
    public static void solve(String digit,String answer,HashMap<Character,String> dial,List<String>result,int i){
        if(i==digit.length()){
            result.add(answer);
            return;
        }
        else{
            String pair=dial.get(digit.charAt(i));
            for(int j=0;j<=pair.length()-1;j++){
                solve(digit,answer+pair.charAt(j),dial,result,i+1);
            }
        }

    }
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits.isEmpty()) {
            return result;}
        else{
        HashMap<Character,String> dial=new HashMap<>();
        dial.put('2',"abc");
        dial.put('3',"def");
        dial.put('4',"ghi");
        dial.put('5',"jkl");
        dial.put('6',"mno");
        dial.put('7',"pqrs");
        dial.put('8',"tuv");
        dial.put('9',"wxyz");
        String answer="";
        solve(digits,answer,dial,result,0);
        return result;}
        

    }
}
