public class Solution {
    public void solve(char[][] board) {
        int nrow = board.length;
        if (nrow == 0) return;
        int ncol = board[0].length;
        
        if (nrow == 1 && ncol == 1) {
            return;
        } 
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        // Loop the outer 
        for (int i = 0; i < ncol - 1; i++) {
            if (board[0][i] == 'O' && !set.contains(myHash(0, i))) {
                addSet(set, board, 0, i);
            }
        }
        
        for (int i = 0; i < nrow - 1; i++) {
            if (board[i][ncol - 1] == 'O' && !set.contains(myHash(i, ncol - 1))) {
                addSet(set, board, i, ncol - 1);
            }
        }
        
        for (int i = ncol - 1; i > 0; i--) {
            if (board[nrow - 1][i] == 'O' && !set.contains(myHash(nrow - 1, i))) {
                addSet(set, board, nrow - 1, i);
            }
        }
        
        for (int i = nrow - 1; i > 0; i--) {
            if (board[i][0] == 'O' && !set.contains(myHash(i, 0))) {
                addSet(set, board, i, 0);
            }
        }
        
        // Loop
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++){
                if (board[i][j] == 'O' && !set.contains(myHash(i, j))) {
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    
    public void addSet(HashSet<Integer> set, char[][] board, int row, int col) {
        
        LinkedList<Integer> rowQueue = new LinkedList<Integer>();
        LinkedList<Integer> colQueue = new LinkedList<Integer>();
        
        rowQueue.add(row);
        colQueue.add(col);
        set.add(myHash(row, col));
        
        while (!rowQueue.isEmpty()) {
            row = rowQueue.remove();
            col = colQueue.remove();
            
            if (row - 1 >= 0 && board[row - 1][col] == 'O' && !set.contains(myHash(row - 1, col))) {
                rowQueue.add(row - 1);
                colQueue.add(col);
                set.add(myHash(row - 1, col));
            }
            
            if (row + 1 < board.length && board[row + 1][col] == 'O' && !set.contains(myHash(row + 1, col))) {
                rowQueue.add(row + 1);
                colQueue.add(col);
                set.add(myHash(row + 1, col));
            }
            
            if (col - 1 >= 0 && board[row][col - 1] == 'O' && !set.contains(myHash(row, col - 1))) {
                rowQueue.add(row);
                colQueue.add(col - 1);
                set.add(myHash(row, col - 1));
            }
            
            if (col + 1 < board[0].length && board[row][col + 1] == 'O' && !set.contains(myHash(row, col + 1))) {
                rowQueue.add(row);
                colQueue.add(col + 1);
                set.add(myHash(row, col + 1));
            }
        }
    }
    
    public int myHash(int row, int col) {
        return 1000 * row + 2 * col;
    }
}