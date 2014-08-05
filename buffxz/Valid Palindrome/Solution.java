public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        int len = s.length();
        if (len == 0) return true;
        
        String str = s.toLowerCase();
        int left = 0;
        int right = len - 1;
        while (left < right) {
            while(left < right && !(str.charAt(left) >= 'a' && str.charAt(left) <= 'z') && !(str.charAt(left) >= '0' && str.charAt(left) <= '9')) left++;
            while(left < right && !(str.charAt(right) >= 'a' && str.charAt(right) <= 'z') && !(str.charAt(right) >= '0' && str.charAt(right) <= '9')) right--;
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        
        return true;
    }
}