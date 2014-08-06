public class Solution {
    public boolean search(int[] A, int target) {
        int len = A.length;
        
        int left = 0, right = len - 1;
        int mid;
        
        
        while (left < right && A[left] == A[right]) {  
            if (A[left] == target) return true;  
                ++left; --right;  
        }
        
        int front = A[left];
        int end = A[right];
        
        if (target >= front) {
            while (left <= right) {
                mid = (left + right) / 2;
                if (A[mid] == target) {
                    return true;
                } else if (A[mid] > target) {
                    right = mid - 1;
                } else if (A[mid] > end) {
                    left = mid + 1;
                } else {
                    if (A[right] > A[left]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        } else if (target <= end) {
            while (left <= right) {
                mid = (left + right) / 2;
                if (A[mid] == target) {
                    return true;
                } else if (A[mid] < target) {
                    left = mid + 1;
                } else if (A[mid] <= end) {
                    right = mid - 1;
                } else {
                    if (A[mid] > end) {
                        left = mid + 1;
                    } else {
                        right = right - 1;
                    }
                }
            }
        }
        
        return false;

    }
}