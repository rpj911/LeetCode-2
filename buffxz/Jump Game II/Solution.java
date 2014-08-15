public class Solution {
    public int jump(int[] A) {
        int len = A.length;
        if (len <= 1) return 0;
        
        int step = 0;
        int next = 0;
        int max = 0;
        for (int i = 0; i < len - 1 && next < len - 1; i++) {
            max = Math.max(max, i + A[i]);
            if (next == i) {
                if (next == max) return -1;
                next = max;
                step++;
            }
        }
        
        return step;
    }
}