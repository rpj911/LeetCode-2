public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int nrow = matrix.length;
        if (nrow == 0) return result;
        
        int ncol = matrix[0].length;
        
        int total = nrow * ncol;
        if (total == 1) {
            result.add(matrix[0][0]);
            return result;
        }
        
        int leftUp = 0;
        int rowDown = nrow - 1;
        int colDown = ncol - 1;
        while (total > 0) {
            // Special case
            if (leftUp == rowDown) {
                for (int i = leftUp; i <= colDown; i++) {
                    result.add(matrix[leftUp][i]);
                }
                return result;
            }
            
            if (leftUp == colDown) {
                for (int i = leftUp; i <= rowDown; i++) {
                    result.add(matrix[i][leftUp]);
                }
                return result;
            }
            
            
            // Loop 4 times - right wards
            for (int i = leftUp; i < colDown; i++) {
                result.add(matrix[leftUp][i]);
            }
            total = total - (colDown - leftUp);
            if (total == 0) return result;
            
            // Down wards
            for (int j = leftUp; j < rowDown; j++) {
                result.add(matrix[j][colDown]);
            }
            total = total - (rowDown - leftUp);
            if (total == 0) return result;
            
            // Left wards
            for (int i = colDown; i > leftUp; i--) {
                result.add(matrix[rowDown][i]);
            }
            total = total - (colDown - leftUp);
            if (total == 0) return result;
            
            // Up wards
            for (int j = rowDown; j > leftUp; j--) {
                result.add(matrix[j][leftUp]);
            }
            total = total - (rowDown - leftUp);
            if (total == 0) return result;
            
            // Update leftUp , rightDown
            leftUp++;
            rowDown--;
            colDown--;
        }
        
        return result;
        
        
    }
}