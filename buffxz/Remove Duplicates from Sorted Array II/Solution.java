public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if (len <= 1) return len;
        
        int count = 0;
        
        for (int i = 2; i < len; i++) {
            if (A[i] == A[i - count - 1] && A[i] == A[i - count - 2]) {
                count++;
            } else {
                A[i - count] = A[i];
            }
        }
        
        return len - count;
    }
}