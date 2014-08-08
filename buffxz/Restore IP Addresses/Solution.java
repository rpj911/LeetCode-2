public class Solution {
    public List<String> restoreIpAddresses(String s) {
        return helper(s, 0);        
    }
    
    private List<String> helper(String s, int level) {
        List<String> res = new ArrayList<String>();
        if (s.length() == 0) return res;
        
        if (level == 3) {
            
            int number = Integer.valueOf(s);
            if (number > 255 ||  (s.length() > 1 && s.charAt(0) == '0')) {
                return res;
            } else {
                res.add(String.valueOf(number));
                return res;
            }
        }
        
        int numberOfRest = (4 - level) * 3;
        if (s.length() > numberOfRest) return res;
        
        for (int i = 1; i < 4; i ++) {
            if (i >= s.length()) break;
            String curString = s.substring(0, i);
            if (curString.length() > 1 && curString.charAt(0) == '0') continue;
            int cur = Integer.valueOf(curString);
            if (cur > 255) continue;
            List<String> subRes = helper(s.substring(i, s.length()), level + 1);
            for (String str : subRes) {
                StringBuilder sb = new StringBuilder();
                sb.append(cur);
                sb.append('.');
                sb.append(str);
                res.add(sb.toString());
            }
        }
        return res;
    }
}