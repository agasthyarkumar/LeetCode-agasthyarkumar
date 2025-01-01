/*class Solution {
    public int maxScore(String s) {
        int ans=0;
        int zero=0;
        int ones=0;
        for(int i=0;i<s.length();i++)
        if(s.charAt(i)=='1')ones++;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0')++zero;
            else --ones;
            ans=Math.max(ans,ones+zero);
        }
        return ans;
    }
}*/
class Solution {
  public int maxScore(String s) {
    int ans = 0;
    int zeros = 0;
    int ones = (int) s.chars().filter(c -> c == '1').count();

    for (int i = 0; i + 1 < s.length(); ++i) {
      if (s.charAt(i) == '0')
        ++zeros;
      else
        --ones;
      ans = Math.max(ans, zeros + ones);
    }

    return ans;
  }
}
