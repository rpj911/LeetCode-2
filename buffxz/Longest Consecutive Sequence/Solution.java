public class Solution {
    public int longestConsecutive(int[] num) {
        int len = num.length;
        if (len == 0) return 0;
        
        Set<Integer> visited = new HashSet<Integer>();
        Map<Integer, Boolean> numbers = new HashMap<Integer, Boolean>();
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < len; i++) {
            numbers.put(num[i], true);
        }
        
        for (Integer number : numbers.keySet()) {
            if (visited.contains(number)) continue;
            int count = 1;
            int i = 1;
            visited.add(number);
            while (numbers.containsKey(number + i)) {
                visited.add(number + i);
                count++;
                i++;
            }
            
            i = 1;
            while (numbers.containsKey(number - i)) {
                visited.add(number - i);
                count++;
                i++;
            }
            max = Math.max(max, count);
        }
        
        return max;
    }
}