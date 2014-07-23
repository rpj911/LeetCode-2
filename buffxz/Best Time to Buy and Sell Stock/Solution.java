public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        
        int maxProfit = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (prices[i] < minNumber) {
                minNumber = prices[i];
            }
            int curProfit = prices[i] - minNumber;
            if (curProfit > maxProfit) {
                maxProfit = curProfit;
            }
        }
        return maxProfit;
    }
}