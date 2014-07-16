public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A.length == 0) return 1;
        for (int i = 0; i < A.length; i++) {
            while (A[i] - 1 >= 0 && A[i] - 1 < A.length && A[i] - 1 != i && A[i] != A[A[i] -1]) {
                swap(A, i, A[i] - 1);
            }
        }
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] -1 != i) {
                return i + 1;
            }
        }
        
        return A.length + 1;
    }
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}