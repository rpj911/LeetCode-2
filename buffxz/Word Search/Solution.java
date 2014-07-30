public class Solution {
    public boolean exist(char[][] board, String word) {
        Set<Integer> set = new HashSet<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int nrow = board.length;
        int ncol = board[0].length;
        
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                if (board[i][j] == word.charAt(0)) {
                    set.add(myHash(i, j));
                    if (helper(board, word, 1, set, i, j, map)) {
                        return true;
                    }
                    set.remove(myHash(i, j));
                }
            }
        }
        
        return false;
    }
    
    public boolean helper(char[][] board, String word, int index, Set<Integer> set, int row, int col, Map<Integer, Integer> map) {
        if (index >= word.length()) {
            return true;
        }
        
        if (map.get(myHash(row, col)) != null && map.get(myHash(row, col)) == index) {
            return false;
        }
        
        int nrow = board.length;
        int ncol = board[0].length;
        
        if (row + 1 < nrow && board[row + 1][col] == word.charAt(index) && !set.contains(myHash(row + 1, col))) {
            set.add(myHash(row + 1, col));
            if (helper(board, word, index + 1, set, row + 1, col, map)) {
                return true;
            }
            set.remove(myHash(row + 1, col));
        }
        
        if (row - 1 >= 0 && board[row - 1][col] == word.charAt(index) && !set.contains(myHash(row - 1, col))) {
            set.add(myHash(row - 1, col));
            if (helper(board, word, index + 1, set, row - 1, col, map)) {
                return true;
            }
            set.remove(myHash(row - 1, col));
        }
        
        if (col + 1 < ncol && board[row][col + 1] == word.charAt(index) && !set.contains(myHash(row, col + 1))) {
            set.add(myHash(row, col + 1));
            if (helper(board, word, index + 1, set, row, col + 1, map)) {
                return true;
            }
            set.remove(myHash(row, col + 1));
        }
        
        if (col - 1 >= 0 && board[row][col - 1] == word.charAt(index) && !set.contains(myHash(row, col - 1))) {
            set.add(myHash(row, col - 1));
            if (helper(board, word, index + 1, set, row, col - 1, map)) {
                return true;
            }
            set.remove(myHash(row, col - 1));
        }
        
        map.put(myHash(row, col) + set.hashCode(), index);
        
        return false;
        
    }
    
    public int myHash(int i, int j) {
        return i * 1000 + j * 9;
    }
}