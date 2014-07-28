public class Solution {
        public static List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        if (n == 0) return result;
        boolean[][] table = new boolean[n][n];
        return helper(n, 0, table);
    }
    
    public  static List<String[]> helper(int n, int row, boolean[][]table) {
        List<String[]> result = new ArrayList<String[]>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append('.');
        }

        String base = sb.toString();
        for (int i = 0; i < n; i++) {
            if (!table[row][i]) {
                // Get cur row String
                StringBuilder builder = new StringBuilder(base);
                builder.insert(i, 'Q');
                String cur = builder.toString();
                if (row == n - 1) {
                    String[] str = new String[n];
                    str[n - 1] = cur;
                    result.add(str);
                    continue;
                }
                // Set table
                boolean[][] subTable = new boolean[n][n];
                for (int k = 0; k < n; k++) {
                	for (int j = 0; j < n; j++) {
                		if (table[k][j]) subTable[k][j] = true;
                	}
                }
                setTable(row, i, subTable);
                // Recurvise get
                List<String[]> subRes = helper(n, row + 1, subTable);
                if (subRes.size() > 0) {
                    for (String[] str : subRes) {
                        str[row] = cur;
                    }
                    result.addAll(subRes);
                }
            }
        }
        return result;
    }
    
    public static void setTable(int row, int col, boolean[][]table) {
        int n = table.length;
        for (int i = 0; i < n; i++) {
            table[row][i] = true;
            table[i][col] = true;
        }
        
        // Diag
        int tempRow = row;
        int tempCol = col;
        while (tempRow - 1 >= 0 && tempCol + 1 < n) {
            table[--tempRow][++tempCol] = true;
        }
        
        tempRow = row;
        tempCol = col;
        while (tempRow + 1 < n && tempCol - 1 >= 0) {
            table[++tempRow][--tempCol] = true;
        }
        
        tempRow = row;
        tempCol = col;
        while (tempRow + 1 < n && tempCol + 1 < n) {
            table[++tempRow][++tempCol] = true;
        }
        
        tempRow = row;
        tempCol = col;
        while (tempRow - 1 >= 0 && tempCol - 1 >= 0) {
            table[--tempRow][--tempCol] = true;
        }
    }
}