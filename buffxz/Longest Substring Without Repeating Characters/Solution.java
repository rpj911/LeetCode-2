public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        
        Set<Character> set = new HashSet<Character>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (!set.contains(c)) {
                set.add(c);
            } else {
                max = Math.max(max, i - left);
                while (arr[left] != c) {
                    set.remove(arr[left]);
                    left++;
                }
                left++;
            }
        }
        
        max = Math.max(max, arr.length - left);
        
        return max;
    }
}