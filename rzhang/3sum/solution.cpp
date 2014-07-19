class Solution {
public:
    vector<vector<int> > threeSum(vector<int> &num) {
        sort(num.begin(), num.end());
        
        vector<vector<int> > ret;
        
        for (int i = 0; i < (int)num.size() - 2; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int x = i + 1;
            int y = num.size() - 1;
            while (x < y) {
                if (num[x] + num[y] < -num[i]) {
                    ++x;
                } else if (num[x] + num[y] > -num[i]) {
                    --y;
                } else {
                    vector<int> tmp;
                    tmp.push_back(num[i]);
                    tmp.push_back(num[x]);
                    tmp.push_back(num[y]);
                    ret.push_back(tmp);
                    do {
                        x++;
                    } while (num[x] == num[x - 1]);
                    do {
                        y--;
                    } while (num[y] == num[y + 1]);
                }
            }
        }
        
        return ret;
    }
};
