public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if (len <= 1) return len;
        
        int count = 0;
        for (int i = 1; i < len; i++) {
            if (A[i] == A[i - 1]) {
                count++;
            } else {
                A[i - count] = A[i];
            }
        }
        
        return len - count;
    }
}