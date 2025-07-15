class Solution {
  public boolean isValid(String word) {
    if (word == null || word.length() < 3) 
      return false;

    boolean hasVowel     = false;
    boolean hasConsonant = false;

    for (int i = 0, len = word.length(); i < len; i++) {
      char c = word.charAt(i);

      // 1) must be letter or digit
      if (!Character.isLetterOrDigit(c)) 
        return false;

      // 2) track vowel vs. consonant
      if (!hasVowel && isVowel(c)) {
        hasVowel = true;
      } else if (!hasConsonant && isConsonant(c)) {
        hasConsonant = true;
      }
    }

    // only valid if we saw both
    return hasVowel && hasConsonant;
  }

  private boolean isVowel(char c) {
    return "aeiouAEIOU".indexOf(c) != -1;
  }

  private boolean isConsonant(char c) {
    return Character.isLetter(c) && !isVowel(c);
  }
}

