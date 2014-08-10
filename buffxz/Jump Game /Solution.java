public class Solution {
    public boolean canJump(int[] A) {
        int len = A.length;
        if (len <= 1) return true;
        
        int next = len - 1;
        for (int i = len - 2; i>=0; i--) {
            int dis = next - i;
            if (A[i] >= dis) {
                next = i;
            }
        }
        
        return next == 0;
    }
}