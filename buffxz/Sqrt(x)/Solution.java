public class Solution {
    public int sqrt(int x) {
        if (x < 2) return x;
        int left = 0;
        int right = x;
        
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int div = x / mid;
            if (mid == div) {
                return mid;
            } else if (mid > div){
                right = mid;
            } else {
                if (left == mid) return left;
                left = mid;
            }
        }
        
        return left;
    }
}