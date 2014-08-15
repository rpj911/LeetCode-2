public class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2; 
        int prevOne = 1;
        int prevTwo = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = prevOne + prevTwo;
            prevOne = prevTwo;
            prevTwo = res;
        }
        
        return res;
    }
}