class Solution {
public:
    int reverse(int x) {
        if (!x) 
            return 0;
            
        int y = abs(x);
        
        int ret = 0;
        
        while (y != 0) {
            ret *= 10;
            ret += y%10;
            y /= 10;
        }
        
        return x/abs(x) * ret; 
    }
};
