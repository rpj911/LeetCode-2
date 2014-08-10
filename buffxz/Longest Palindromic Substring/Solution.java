public class Solution {
    public String longestPalindrome(String s) {
        char[] array = s.toCharArray();
        
        int max = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < array.length && array[left] == array[right]) {
                left--;
                right++;
            }
            if ((right - 1) - (left + 1) + 1 > max) {
                max = (right - 1) - (left + 1) + 1;
                index = left + 1;
            }
            
            left = i;
            right = i + 1;
            while (left >= 0 && right < array.length && array[left] == array[right]) {
                left--;
                right++;
            }
            if ((right - 1) - (left + 1) + 1 > max) {
                max = (right - 1) - (left + 1) + 1;
                index = left + 1;
            }
        }
        
        return s.substring(index, index + max);
    }
}