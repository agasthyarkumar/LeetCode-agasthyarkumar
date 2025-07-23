class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return process(s, "ab", x, "ba", y);
        } else {
            return process(s, "ba", y, "ab", x);
        }
    }

    private int process(String s, String first, int firstPoints, String second, int secondPoints) {
        StringBuilder temp = new StringBuilder();
        int score = 0;

        for (char c : s.toCharArray()) {
            temp.append(c);
            int len = temp.length();
            if (len >= 2 && temp.substring(len - 2).equals(first)) {
                temp.delete(len - 2, len);
                score += firstPoints;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < temp.length(); i++) {
            result.append(temp.charAt(i));
            int len = result.length();
            if (len >= 2 && result.substring(len - 2).equals(second)) {
                result.delete(len - 2, len);
                score += secondPoints;
            }
        }

        return score;
    }
}

