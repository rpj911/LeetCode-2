class Solution {
public:
    bool isnum(string s) {
        if (s.length() > 0 && s[0] >= '0' && s[0] <= '9') {
            return true;
        }
        
        if (s.length() > 1 && (s[0] == '-' || s[0] == '+') && s[1] >= '0' && s[1] <= '9') {
            return true;
        }
        
        return false;
    }
    
    int evalRPN(vector<string> &tokens) {
        stack<int> s;
        for (int i = 0; i < tokens.size(); ++i) {
            if (isnum(tokens[i])) {
                s.push(atoi(tokens[i].c_str()));
            } else {
                if (s.size() < 2)
                    return -1;
                int sec = s.top();
                s.pop();
                int fir = s.top();
                s.pop();
                int res = 0;
                if (tokens[i] == "+") {
                    res = fir + sec;
                } else if (tokens[i] == "-") {
                    res = fir - sec;
                } else if (tokens[i] == "*") {
                    res = fir * sec;
                } else if (tokens[i] == "/") {
                    res = fir / sec;
                } else {
                    return -1;
                }
                s.push(res);
            }
        }
        if (s.size() > 1) {
            return -1;
        } else if (s.size() == 0) {
            return 0;
        } else {
            return s.top();
        }
    }
};
