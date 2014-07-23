class Solution {
public:
    void reverseWords(string &s) {
        vector<string> words;
        string word = "";
        
        for (int i = 0; i < s.length(); ++i) {
            if (s[i] == ' ' && word.length() > 0) {
                words.push_back(word);
                word = "";
            } else if (s[i] != ' ') {
                word += s[i];
            }
        }
        
        if (word.length() > 0) {
            words.push_back(word);
        }
        
        s = "";
        for (int i = words.size() - 1; i > -1; --i) {
            s += words[i] + " ";
        }
        
        if (s.length() > 0) {
            s = s.substr(0, s.length() - 1);
        }
        
    }
};
