public class Solution {
    public static int largestRectangleArea(int[] height) {  
        int len = height.length;
        if (len == 0) return 0;
         
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (stack.peek() == -1) {
            	stack.push(i);
            	continue;
            }
            int peekIndex = stack.peek();
            int curNum = height[i];
            if (height[peekIndex] <= curNum) {
                stack.push(i);
            } else {
                // The special one
                int iniINDEX = stack.pop();
                int comIndex = stack.peek();
                while (comIndex != -1 && height[iniINDEX] == height[comIndex]) {
                	comIndex--;
                }
                max = Math.max(max, height[iniINDEX] * (iniINDEX - comIndex));
                int prevIndex = iniINDEX;
                while(stack.peek() > -1 && height[stack.peek()] > curNum) {
                    int curIndex = stack.pop();
                    max = Math.max(max, height[curIndex] * (iniINDEX - stack.peek()));
                    prevIndex = curIndex;
                }
                stack.push(i);
            }
        }
        
        if (!stack.isEmpty()) {
            int iniINDEX = stack.pop();
            int comIndex = stack.peek();
            while (comIndex != -1 && height[iniINDEX] == height[comIndex]) {
            	comIndex--;
            }
            max = Math.max(max, height[iniINDEX] * (iniINDEX - comIndex));
            int prevIndex = iniINDEX;
            while (stack.peek() > -1) {
                int curIndex = stack.pop();
                max = Math.max(max, height[curIndex] * (iniINDEX - stack.peek()));
                prevIndex = curIndex;
            }
        }
        
        return max;
         
    }
}