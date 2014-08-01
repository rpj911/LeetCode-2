public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        if (len1 == 0 || len2 == 0) return len1 + len2;
        
        int[][] table = new int[len2 + 1][len1 + 1];
        
        for (int i = 0; i < len1 + 1; i++) {
            table[0][i] = i;
        }
        
        for (int i = 0; i < len2 + 1; i++) {
            table[i][0] = i;
        }
        
        for (int i = 1; i < len2 + 1; i++) {
            for (int j = 1; j < len1 + 1; j++) {
                int left = table[i][j - 1] + 1;
                int up = table[i - 1][j] + 1;
                int diag = table[i - 1][j - 1];
                if (word1.charAt(j - 1) != word2.charAt(i - 1)) diag++;
                table[i][j] = Math.min(Math.min(left, up), diag);
            }
        }
        
        return table[len2][len1];
    }
}