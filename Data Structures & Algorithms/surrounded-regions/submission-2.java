class Solution {
    int ROWS;
    int COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if((i == 0 || i == ROWS -1 || j == 0 || j == COLS -1) && board[i][j] == 'O'){
                    dfs(i,j,board);
                }
            }
        }

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }

                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board){
        if(r < 0 || r == ROWS || c < 0 || c == COLS || board[r][c] != 'O'){
            return;
        }

        board[r][c] = 'T';
        dfs(r+1,c, board);
        dfs(r-1,c, board);
        dfs(r,c+1, board);
        dfs(r,c-1, board);
    }
}
