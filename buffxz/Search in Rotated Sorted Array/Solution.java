public class Solution {
    public int search(int[] A, int target) {
        int len = A.length;
        int front = A[0];
        int end = A[len - 1];
        
        int left = 0, right = len - 1;
        int mid;
        
        if (target >= front) {
            while (left <= right) {
                mid = (left + right) / 2;
                if (A[mid] == target) {
                    return mid;
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
                    return mid;
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
        
        return -1;

    }
}