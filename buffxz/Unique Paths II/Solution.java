public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] table = new int[m][n];
        
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1 || (i > 0 && table[0][i - 1] == 0)) {
                table[0][i] = 0;
            } else {
                table[0][i] = 1;
            }
        }
        
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1 || (i > 0 && table[i - 1][0] == 0)) {
                table[i][0] = 0;
            } else {
                table[i][0] = 1;
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    table[i][j] = 0;
                } else {
                    int up = table[i - 1][j];
                    int left = table[i][j - 1];
                    table[i][j] = up + left;
                }
            }
        }
        
        return table[m -1][n - 1];
    }
}