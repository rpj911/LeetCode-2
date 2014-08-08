public class Solution {
    public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        
        if (m < n) return 0;
        if (n == 0) return 0;
        
        int[][] table = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > i) continue;
                if (i == 0 && j == 0) {
                    table[i][j] = S.charAt(i) == T.charAt(j) ? 1 : 0;
                    continue;
                }
                
                if (j == 0) {
                    table[i][j] = table[i - 1][j] + (S.charAt(i) == T.charAt(j) ? 1 : 0);
                    continue;
                }
                
                table[i][j] = table[i - 1][j] + (S.charAt(i) == T.charAt(j) ? table[i - 1][j - 1] : 0);
            }
        }
        
        return table[m - 1][n - 1];
    }
}