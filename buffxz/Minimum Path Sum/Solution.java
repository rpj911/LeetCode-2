public class Solution {
    public int minPathSum(int[][] grid) {
        int nrow = grid.length;
        if (nrow == 0) return 0;
        int ncol = grid[0].length;
        
        int[][] table = new int[nrow][ncol];
        
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                if (i == 0 && j == 0) {
                    table[0][0] = grid[0][0];
                    continue;
                }
                int cur = grid[i][j];
                int minUp = Integer.MAX_VALUE;
                int minLeft = Integer.MAX_VALUE;
                if (i - 1 >= 0) minUp = table[i - 1][j];
                if (j - 1 >= 0) minLeft = table[i][j - 1];
                table[i][j] = Math.min(minUp, minLeft) + cur;
            }
        }
        
        return table[nrow -1][ncol - 1];
    }
}