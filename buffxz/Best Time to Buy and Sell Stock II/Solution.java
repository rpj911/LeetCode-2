public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        
        int min = Integer.MAX_VALUE;
        int total = 0;
        for (int i = 0; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else{
                total += prices[i] - min;
                min = prices[i];
            }
        }
        return total;
    }
}