public class Solution {
    public void nextPermutation(int[] num) {
        int len = num.length;
        if (len == 0) return;
        
        // find the first down
        int p = len - 1;
        while(p > 0) {
            if (num[p] > num[p - 1]) break;
            p--;
        }
        
        if (p != 0) {
            int q = p;
            while (q < len - 1) {
                if (num[q + 1] <= num[p - 1]) break;
                q++;
            }
            
            swap(num, q, p - 1);
        }
        
        int left = p;
        int right = len - 1;
        while (left < right) {
            swap(num, left, right);
            left++;
            right--;
        }
    }
    
    public void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}