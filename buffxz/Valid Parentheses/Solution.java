public class Solution {
    public boolean isValid(String s) {
        if (s == null) return false;
        char[] array = s.toCharArray();
        if (array.length == 0) return false;
        
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty()) {
                stack.push(array[i]);
                continue;
            }
            char curChar = array[i];
            char topChar = stack.peek();
            if (curChar == '}') {
                if (topChar == '{') {
                    stack.pop();
                } else {
                    stack.push(curChar);
                }
            } else if (curChar == ')') {
                if (topChar == '(') {
                    stack.pop();
                } else {
                    stack.push(curChar);
                }
            } else if (curChar == ']') {
                if (topChar == '[') {
                    stack.pop();
                } else {
                    stack.push(curChar);
                }
            } else {
                stack.push(curChar);
            }
            
        }
        
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}