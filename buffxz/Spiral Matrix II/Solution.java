public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }
        
        int total = n * n;
        int count = 0;
        int leftUp = 0;
        int rightDown = n - 1;
        
        while (count < total) {
            // Check whether it is the last one
            if (leftUp == rightDown) {
                result[leftUp][leftUp] = ++count;
                return result;
            }
            
            for (int i = leftUp; i < rightDown; i++) {
                result[leftUp][i] = ++count;
            }
            
            for (int i = leftUp; i < rightDown; i++) {
                result[i][rightDown] = ++count;
            }
            
            for (int i = rightDown; i > leftUp; i--) {
                result[rightDown][i] = ++count;
            }
            
            for (int i = rightDown; i > leftUp; i--) {
                result[i][leftUp] = ++count;
            }
            
            // Update
            leftUp++;
            rightDown--;
        }
        
        return result;
        
    }
}