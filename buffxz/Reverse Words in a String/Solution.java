public class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        
        int length = s.length();
        
        if (length == 0) {
            return "";
        }
        
        int pointer = length - 1;
        int start = -1;
        int end = length - 1;
        
        //get to the first char which in not space
        boolean flag = false;
        StringBuilder builder = new StringBuilder();
        
        //start
        while (pointer >=0){
            while (s.charAt(pointer) == ' ') {
                pointer --;
                if (pointer < 0){
                    flag = true;
                    break;
                }
            }
            if (flag) break;
            
            start = pointer;
            while (s.charAt(pointer) != ' ') {
                pointer--;
                if (pointer < 0) {
                    end = 0;
                    break;
                }
            }
            
            end = pointer + 1;
            
            for (int i = end; i <= start; i++) {
                builder.append(s.charAt(i));
            }
            builder.append(' ');
        }
        
        //remove the last one
        if (builder.length() > 0 && builder.charAt(builder.length() - 1) == ' ') builder.deleteCharAt(builder.length() - 1);
        
        String result = builder.toString();
        return result;
    }
}