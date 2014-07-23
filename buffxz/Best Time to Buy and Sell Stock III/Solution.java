public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int[] leftWards = new int[len];
        int[] rightWards = new int[len];
        // Get the left wards array
        int maxProfitL = 0;
        int minNumber = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (prices[i] < minNumber) {
                minNumber = prices[i];
            } else {
                if (prices[i] - minNumber > maxProfitL) {
                    maxProfitL = prices[i] - minNumber;
                }
            }
            leftWards[i] = maxProfitL;
        }
        
        // Get the right wards array
        int maxProfitR = 0;
        int maxNumber = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0 ; i--) {
            if (prices[i] > maxNumber) {
                maxNumber = prices[i];
            } else {
                if (maxNumber - prices[i] > maxProfitR) {
                    maxProfitR = maxNumber - prices[i];
                }
            }
            rightWards[i] = maxProfitR;
        }
        
        // Total
        int total = 0;
        for (int i = 0; i < len; i++) {
            if (leftWards[i] + rightWards[i] > total) {
                total = leftWards[i] + rightWards[i];
            }
        }
        
        return total;
    }
}