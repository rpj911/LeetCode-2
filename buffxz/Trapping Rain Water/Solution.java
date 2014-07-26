public class Solution {
    public int trap(int[] A) {
        int len = A.length;
        if (len == 0) return 0;
        
        int left = 0;
        int right = len - 1;
        while (left + 1 < len && A[left + 1] >= A[left]) left++;
        while (right - 1 >= 0 && A[right - 1] >= A[right]) right--;
        
        int sum = 0;
        int solid = 0;
        int bar = A[left];
        int barIndex = left;
        
        for (int i = left + 1; i <= right; i++) {
            if (A[i] < bar) {
                solid += A[i];
            } else {
                sum += (i - barIndex - 1) * bar - solid;
                solid = 0;
                bar = A[i];
                barIndex = i;
            }
        }
        
        solid = 0;
        bar = A[right];
        barIndex = right;
        for (int i = right - 1; i >= left; i--) {
            if (A[i] <= bar) {
                solid += A[i];
            } else {
                sum += (barIndex - i - 1) * bar - solid;
                solid = 0;
                bar = A[i];
                barIndex = i;
            }
        }
        return sum;
    }
}