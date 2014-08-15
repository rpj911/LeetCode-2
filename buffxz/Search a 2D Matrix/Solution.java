public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return helper(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }
    
    public boolean helper(int[][] matrix, int leftRow, int leftCol, int rightRow, int rightCol, int target) {
        
        if (leftRow == rightRow && leftCol == rightCol) return target == matrix[leftRow][leftCol];
        if (leftRow > rightRow || leftCol > rightCol) return false;
        
        int midRow = (leftRow + rightRow) / 2;
        int midCol = (leftCol + rightCol) / 2;
        
        int num = matrix[midRow][midCol];
        
        if (num == target) return true;
        if (num > target) {
            return helper(matrix, leftRow, leftCol, midRow - 1, rightCol, target) || 
                   helper(matrix, midRow, leftCol, midRow, midCol - 1, target);
        }
        
        return helper(matrix, leftRow, midCol + 1, rightRow, rightCol, target) ||
               helper(matrix, midRow + 1, leftCol, rightRow, midCol, target);
    }
}