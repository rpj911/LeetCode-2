public class Solution {
    public String simplifyPath(String path) {
        if (path == null) return null;
        int len = path.length();
        if (len == 0) return "";
        
        Stack<String> stack = new Stack<String>();
        int head = 0;
        int end = 0;
        for (int i = 1; i < len; i++) {
            if (path.charAt(i) == '/') {
                end = i;
                if (path.charAt(i - 1) == '/') {
                    head = i;
                    continue;
                }
                String cur = path.substring(head + 1, end);
                if (cur.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (cur.equals(".")) {
                    // ignore
                } else {
                    stack.push(cur);
                }
                head = end;
            }
        }
        
        if (head + 1 < len) {
            String cur = path.substring(head + 1, len);
            if (cur.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (cur.equals(".")) {
                // ignore
            } else {
                stack.push(cur);
            }
        }
        
        if (!stack.isEmpty()) {
            StringBuilder  sb = new StringBuilder();
            sb.append('/');
            boolean hasword = false;
            for (String str : stack) {
                sb.append(str);
                sb.append('/');
                hasword = true;
            }
            if (hasword) sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        } else {
            return "/";
        }
    }
}