class Solution {
    public int[] vowelStrings(String[] words, int[][] q) {
        int[] prefixSum = new int[words.length + 1];
        
        // Precompute the prefix sum array for valid vowel strings
        for (int i = 0; i < words.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + (isValid(words[i]) ? 1 : 0);
        }
        
        int[] result = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            int start = q[i][0];
            int end = q[i][1];
            // Calculate the number of valid vowel strings in the range using the prefix sum
            result[i] = prefixSum[end + 1] - prefixSum[start];
        }
        
        return result;
    }
    
    private boolean isValid(String word) {
        char start = word.charAt(0);
        char end = word.charAt(word.length() - 1);
        return isVowel(start) && isVowel(end);
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

/*class Solution {
    public int[] vowelStrings(String[] words, int[][] q) {
        int[] count=new int[q.length];
        for(int i=0;i<q.length;i++){
            String[] n=Arrays.copyOfRange(words, q[i][0], q[i][1]+1);
            int sum=0;
            for(String a:n){
                if(isvalid(a)) sum++;
            }
            count[i]=sum;
        }
        return count;
        
    }
    public boolean isvalid(String word){
        char a=word.charAt(0);
        char b=word.charAt(word.length()-1);
        return ((a=='a'||a=='e'||a=='i'||a=='o'||a=='u')&&(b=='a'||b=='e'||b=='i'||b=='o'||b=='u'));
    }
}
 */

