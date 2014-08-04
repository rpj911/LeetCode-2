public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] table = new int[m][n];
        
        for (int i = 0; i < n; i++) {
            table[0][i] = 1;
        }
        
        for (int i = 0; i < m; i++) {
            table[i][0] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int up = table[i - 1][j];
                int left = table[i][j - 1];
                table[i][j] = up + left;
            }
        }
        
        return table[m -1][n - 1];
    }
}