class Solution {

public:
    bool wordBreak(string s, unordered_set<string> &dict) {
        bool* tmp = new bool[s.length()];
        memset(tmp, 0, s.length());
        for (int i = s.length(); i > 0; --i) {
            if (i == s.length() || tmp[i]) {
                for (int j = 0; j < i; ++j) {
                    string str = s.substr(j, i - j);
                    if (dict.find(str) != dict.end()) {
                        tmp[j] = true;
                        if (j == 0)
                            return true;
                    }
                }
            }
        }
        
        return false;

    }
};
