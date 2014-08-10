public class Solution {
    public int longestValidParentheses(String s) {
        char[] array = s.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        
        int max = 0;
        int prev = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ')') {
                if (stack.isEmpty()) {
                    prev = i;
                } else {
                    int cur = stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(i - prev, max);
                    } else {
                        max = Math.max(i - stack.peek(), max);
                    }
                }
            } else {
                stack.push(i);
            }
        }
        
        return max;        
    }
}