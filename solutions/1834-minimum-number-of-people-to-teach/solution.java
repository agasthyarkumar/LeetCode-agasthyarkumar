class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        Set<Integer>[] userLangSets = new HashSet[m];
        for (int i = 0; i < m; i++) {
            userLangSets[i] = new HashSet<>();
            for (int lang : languages[i]) {
                userLangSets[i].add(lang);
            }
        }
        Set<Integer> problemUsers = new HashSet<>();
        for (int[] friendship : friendships) {
            int u = friendship[0] - 1;
            int v = friendship[1] - 1;
            if (!canCommunicate(userLangSets, u, v)) {
                problemUsers.add(u);
                problemUsers.add(v);
            }
        }
        if (problemUsers.isEmpty()) {
            return 0;
        }
        int[] langCounts = new int[n + 1];
        int maxFreq = 0;
        for (int user : problemUsers) {
            for (int lang : userLangSets[user]) {
                langCounts[lang]++;
                maxFreq = Math.max(maxFreq, langCounts[lang]);
            }
        }
        return problemUsers.size() - maxFreq;
    }
     private boolean canCommunicate(Set<Integer>[] userLangSets, int u, int v) {
        Set<Integer> setU = userLangSets[u];
        Set<Integer> setV = userLangSets[v];
        if (setU.size() > setV.size()) {
            Set<Integer> temp = setU;
            setU = setV;
            setV = temp;
        }
        for (int lang : setU) {
            if (setV.contains(lang)) {
                return true;
            }
        }
        return false;
    }
}
