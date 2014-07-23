public class Solution {
    public int minCut(String s) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        boolean[][] table = buildPalindromeTable(s);
        return helper(s, map, table, 0, s.length() - 1);        
    }
    
    public int helper(String s, HashMap<Integer, Integer> map, boolean[][] table, int left, int right) {
        if (map.get(left) != null) {
            return map.get(left);
        } 
        
        if (left == right) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = left; i <= right; i++) {
            if (table[left][i]) {
                if (i == right) {
                    map.put(left, 0);
                    return 0;
                } else {
                    int cur;
                    if (map.get(i + 1) != null) {
                        cur = map.get(i + 1);
                    } else {
                        cur = helper(s, map, table, i + 1, right);
                    }
                    
                    if (cur == -1) continue;
                    
                    if (cur + 1 < min) {
                        min = cur + 1;
                    }
                }
            }
        }
             
        if (min == Integer.MAX_VALUE)  {
            min = -1;
        }
        map.put(left, min);
        return min;
    }
    
    public boolean isPalindrome(String s) {
        int left = 0; 
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
     private boolean[][] buildPalindromeTable(String s) {  
   int len = s.length();  
   // T[i][j] == true iff s[i..j] is a palindrome  
   boolean[][] T = new boolean[len][len];  
   for (int i=0; i<len; ++i) {  
     T[i][i] = true;  
     // odd case  
     int l = i-1, r = i+1;  
     while (l>=0 && r<len && s.charAt(l)==s.charAt(r)) {  
       T[l--][r++] = true;  
     }  
     // even case  
     l = i; r = i+1;  
     while (l>=0 && r<len && s.charAt(l)==s.charAt(r)) {  
       T[l--][r++] = true;  
     }  
   }  
   return T;  
 }  
}