public class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        if (len == 0) return 0;
        
        int max = 0;
        int left = 0; 
        int right = len -1;
        
        while (left < right) {
            max = Math.max(max, (right - left)*Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return max;
    }
}