public class Solution {
    
    public int totalNQueens(int n) {
        if (n == 0) return 0;
        boolean[] colOcp = new boolean[n];
        boolean[] leftOcp = new boolean[2 * n];
        boolean[] rightOcp = new boolean[2 * n];
        return helper(n, 0, colOcp, leftOcp, rightOcp);
    }
    
    public  static int helper(int n, int row, boolean[] colOcp, boolean[] leftOcp, boolean[] rightOcp) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (!colOcp[i] && !leftOcp[i + row] && !rightOcp[n - row + i]) {
                if (row == n - 1) {
                    sum += 1;
                    continue;
                }
                colOcp[i] = true;
                leftOcp[row + i] = true;
                rightOcp[n - row + i] = true;
                int temp = helper(n, row + 1, colOcp, leftOcp, rightOcp);
                sum += temp;
                // Reset
                colOcp[i] = false;
                leftOcp[row + i] = false;
                rightOcp[n - row + i] = false;
            }
        }
        return sum;
    }
           
}