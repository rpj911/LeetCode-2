public class Solution {
    public int removeElement(int[] A, int elem) {
        int len = A.length;
        if (len == 0) return 0;
        
        int left = 0; 
        int right = len - 1;
        
        while (left <= right) {
            while (left <= right && A[left] != elem) {
                left++;
            }
            if (left >= right) return left;
            while (left <= right && A[right] == elem) {
                right--;
            }
            if (left >= right) return left;
            swap(A, left, right);
        }
        
        return left;
    }
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}