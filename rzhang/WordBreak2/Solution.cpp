class Solution {
    void helper(vector<string>& ret, string& s, vector<int>* tmp, int pos, string str) {
        if (pos == s.length()) {
            ret.push_back(str.substr(0, str.length() - 1));
            return;
        }
        
        for (int i = 0; i < tmp[pos].size(); ++i) {
            helper(ret, s, tmp, tmp[pos][i], str + s.substr(pos, tmp[pos][i] - pos) + " ");
        }
    }
public:
    vector<string> wordBreak(string s, unordered_set<string> &dict) {
        vector<int>* tmp = new vector<int>[s.length()];
        for (int i = s.length(); i > 0; --i) {
            if (i == s.length() || tmp[i].size() > 0) {
                for (int j = 0; j < i; ++j) {
                    string str = s.substr(j, i - j);
                    if (dict.find(str) != dict.end()) {
                        tmp[j].push_back(i);
                    }
                }
            }
        }
        
        vector<string> ret;
        helper(ret, s, tmp, 0, "");
        
        return ret;
    }
};
