class Solution {
    void helper(vector<vector<char>>& board, int x, int y) {
        board[x][y] = 'Y';
        if (x > 0 && board[x-1][y] == 'O') {
            helper(board, x-1,y);
        }
        if (x < board.size()-1 && board[x+1][y] == 'O') {
            helper(board, x+1, y);
        }
        if (y > 0 && board[x][y-1] == 'O') {
            helper(board,x,y-1);
        }
        if (y < board[0].size()-1 && board[x][y+1] == 'O') {
            helper(board,x,y+1);
        }
    }
public:
    void solve(vector<vector<char>> &board) {
        if (!board.size()) {
            return;
        }
        
        int h = board.size();
        int w = board[0].size();
        
        for (int i = 0; i < h;i++) {
            if (board[i][0] == 'O')
                helper(board,i,0);
            if (board[i][w-1] == 'O')
                helper(board,i,w-1);
        }
        
        for (int i = 1; i < w-1; i++) {
            if (board[0][i] == 'O')
                helper(board,0,i);
            if (board[h-1][i] == 'O')
                helper(board,h-1,i);
        }
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w;j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
        
    }
};
