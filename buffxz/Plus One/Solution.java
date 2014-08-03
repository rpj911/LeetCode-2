public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        
        int newLen = 0;
        boolean allNine = true;
        for (int i = 0; i < len; i++) {
            if (digits[i] != 9) {
                allNine = false;
            }
        }
        
        int[] result;
        if (allNine) {
            newLen = len + 1;
            result = new int[newLen];
            result[0] = 1;
            return result;
        } else {
            newLen = len;
        }
        
        result = new int[newLen];
        int carry = 0;
        int firstOne = 1;
        for (int i = newLen - 1; i >= 0; i--) {
            result[i] = (digits[i] + firstOne) % 10;
            if (digits[i] + firstOne >= 10) {
                firstOne = 1;
            } else {
                firstOne = 0;
            }
        }
        
        return result;
        
    }
}