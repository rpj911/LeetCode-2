public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        return helper(s, dict, map);
    }
    
    public boolean helper(String s, Set<String> dict, HashMap<Integer, Boolean> map) {
        if (dict.contains(s)) {
            return true;
        }
        
        for (int i = 1; i < s.length() + 1; i++) {
            if (dict.contains(s.substring(0, i))) {
                if (map.get(i) != null && map.get(i) == false) continue;
                if (map.get(i) != null && map.get(i) == true) return true;
                if (helper(s.substring(i, s.length()), dict, map)) {
                    return true;
                } else {
                    map.put(i, false);
                }
            }
        }
        return false;
    }
}