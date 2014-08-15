public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) return "";
        
        boolean flag = true;
        int index = -1;
        while (flag) {
            index++;
            if (index >= strs[0].length()) break;
            char cur = strs[0].charAt(index);
            for (int i = 0; i < len; i++) {
                if (index >= strs[i].length() || strs[i].charAt(index) != cur) {
                    flag = false;
                    break;
                }
            }
        }
        
        return strs[0].substring(0, index);
    }
}