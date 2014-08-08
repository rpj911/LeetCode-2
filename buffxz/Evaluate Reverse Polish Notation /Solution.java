public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        
        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];
            int num1, num2;
            switch (c) {
                case "+":
                    num1 = Integer.valueOf(stack.pop());
                    num2 = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(num2 + num1));
                    break;
                    
                case "-":
                    num1 = Integer.valueOf(stack.pop());
                    num2 = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(num2 - num1));
                    break;
                    
                case "*":
                    num1 = Integer.valueOf(stack.pop());
                    num2 = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(num2 * num1));
                    break;
                    
                case "/":
                    num1 = Integer.valueOf(stack.pop());
                    num2 = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(num2 / num1));
                    break;
                    
                default:
                    stack.push(c);
            }
        }
        
        return Integer.valueOf(stack.pop());
    }
}