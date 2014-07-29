import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null) return result;
        if (digits.length() == 0) {
            result.add("");
            return result;
        }
        
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Stack<Wrapper> stack = new Stack<Wrapper>();
        
        char[] array = digits.toCharArray();
        for (int i = 0; i < array.length; i++) {
            stack.push(new Wrapper(Integer.valueOf(String.valueOf(array[i])), 0));
        }
        
        Stack<Wrapper> temp = new Stack<Wrapper>();
        while(true) {
            Wrapper cur = stack.pop();
            int length = dict[cur.digit].length();
            if (cur.index >= length) {
            	if (stack.isEmpty()) {
            		break;
            	}
            	cur.index = 0;
            	stack.peek().index++;
            	stack.push(cur);
            } else {
            	temp.push(cur);
            	if (stack.isEmpty()) {
            		StringBuilder builder = new StringBuilder();
            		while(!temp.isEmpty()) {
            			Wrapper itrWrapper = temp.pop();
            			String curString = dict[itrWrapper.digit];
            			builder.append(curString.charAt(itrWrapper.index));
            			stack.push(itrWrapper);
            		}
            		result.add(builder.toString());
            		stack.peek().index++;
            	}
            }
        }
        
        return result;
    }
    
    public static class Wrapper {
        int digit;
        int index;
        Wrapper(int digit, int index) {
            this.digit = digit;
            this.index = index;
        }
    }
}