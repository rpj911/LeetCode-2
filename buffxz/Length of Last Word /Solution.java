public class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int end = len - 1;
        while (s.charAt(end) == ' ') {
            end--;
            if (end < 0) return 0;
        }
        
        int head = end;
        while (s.charAt(head) != ' ') {
            head--;
            if (head < 0) return end + 1;
        }
        
        return end - head;
    }
}