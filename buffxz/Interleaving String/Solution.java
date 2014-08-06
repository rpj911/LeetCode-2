public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        if (s3.length() == 0) return true;
        Map<String, String> map = new HashMap<String, String>();
        return helper(s1, s2, s3, map, 0, 0, 0);
    }
    
    public boolean helper(String s1, String s2, String s3, Map<String, String> map, int p1, int p2, int p3) {
        if (p3 == s3.length()) return true;
        
        if (map.get(p1 + "," + p2) != null && map.get(p1 + "," + p2).equals(s3)) return false;
        
        if (p1 < s1.length() && s1.charAt(p1) != s3.charAt(p3) && p2 < s2.length() && s2.charAt(p2) != s3.charAt(p3)) {
            map.put(p1 + "," + p2, s3);
            return false;
        }
        
        if (p1 < s1.length() && s1.charAt(p1) == s3.charAt(p3)) {
            if (helper(s1, s2, s3, map, p1 + 1, p2, p3 + 1)) {
                return true;
            }
        }
        
        if (p2 < s2.length() && s2.charAt(p2) == s3.charAt(p3)) {
            if (helper(s1, s2, s3, map, p1, p2 + 1, p3 + 1)) {
                return true;
            }
        }
        
        map.put(p1 + "," + p2, s3);
        return false;
    }
}