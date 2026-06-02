class Solution {
public:
    vector<vector<string>> findLadders(
        string beginWord,
        string endWord,
        vector<string>& wordList) {

        unordered_set<string> dict(
            wordList.begin(),
            wordList.end());

        vector<vector<string>> ans;

        if (!dict.count(endWord))
            return ans;

        unordered_map<string, vector<string>> parents;
        unordered_map<string, int> level;

        queue<string> q;

        q.push(beginWord);
        level[beginWord] = 0;

        int wordLen = beginWord.size();

        while (!q.empty()) {

            string word = q.front();
            q.pop();

            int curLevel = level[word];

            string temp = word;

            for (int i = 0; i < wordLen; i++) {

                char original = temp[i];

                for (char c = 'a'; c <= 'z'; c++) {

                    temp[i] = c;

                    if (!dict.count(temp))
                        continue;

                    if (!level.count(temp)) {

                        level[temp] = curLevel + 1;
                        q.push(temp);

                        parents[temp].push_back(word);
                    }
                    else if (level[temp] == curLevel + 1) {

                        parents[temp].push_back(word);
                    }
                }

                temp[i] = original;
            }
        }

        if (!level.count(endWord))
            return ans;

        vector<string> path;

        dfs(endWord,
            beginWord,
            parents,
            path,
            ans);

        return ans;
    }

private:
    void dfs(
        string word,
        string beginWord,
        unordered_map<string, vector<string>>& parents,
        vector<string>& path,
        vector<vector<string>>& ans) {

        path.push_back(word);

        if (word == beginWord) {

            vector<string> cur = path;
            reverse(cur.begin(), cur.end());

            ans.push_back(cur);
        }
        else {

            for (string& p : parents[word]) {
                dfs(p,
                    beginWord,
                    parents,
                    path,
                    ans);
            }
        }

        path.pop_back();
    }
};
