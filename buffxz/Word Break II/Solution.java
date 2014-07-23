public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        return helper(s, dict, map);
    }
    
    public List<String> helper(String s, Set<String> dict, HashMap<String, List<String>> map) {
        // cache
        if (map.get(s) != null){
            return map.get(s);
        }
        
        // 
        List<String> result= new ArrayList<String>();
        for (int i = 1; i < s.length() + 1; i++) {
            if (dict.contains(s.substring(0, i))) {
                if (i == s.length()) {
                    // No behind
                    result.add(s);
                } else {
                    List<String> behind = helper(s.substring(i, s.length()), dict, map);
                    if (behind.size() != 0) {
                        for (String subBeh : behind) {
                            StringBuilder builder = new StringBuilder();
                            builder.append(s.substring(0, i) + " ");
                            builder.append(subBeh);
                            result.add(builder.toString());
                        }
                    }
                }
            }
        }
        
        map.put(s, result);
        
        return result;
    }
}