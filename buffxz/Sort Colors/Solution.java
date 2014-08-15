public class Solution {
    public void sortColors(int[] A) {
        int len = A.length;
        int left = 0;
        int right = len - 1;
        int cur = 0;
        
        while (cur <= right) {
            if (A[cur] == 0) {
                swap(A, cur++, left++);
            } else if (A[cur] == 2) {
                swap(A, cur, right--);
            } else {
                cur++;
            }
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}