public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;        
        if (s.charAt(0) == '0') return 0;
        
        int[] array = new int[s.length()];
        
        int i = array.length - 1;
        boolean lock = false;
        while (i >= 0) {
            
            if (Integer.valueOf(s.substring(i, i + 1)) == 0) {
                i--;
                int next = Integer.valueOf(s.substring(i, i + 2));
                if (next == 0 || next > 26 ) return 0;
                array[i] = i == array.length - 2 ? 1 : array[i + 2];
                lock = true;
                i--;
                continue;
            }
            
            if (lock) {
                lock = false;
                array[i] = array[i + 1];
                i--;
                continue;
            }
            
            if (i == array.length - 1) {
                array[i] = 1;
                i--;
                continue;
            }
            
            
            //get int
            int cur = Integer.valueOf(s.substring(i, i + 2));
            if (cur <= 26 ) {
                if (i < array.length - 2) {
                    array[i] = array[i + 1] + array[i + 2];
                } else {
                    array[i] = array[i + 1] + 1;
                }
            } else {
                array[i] = array[i + 1];
            }
            i--;
        }
        
        return array[0];
        
    }
}