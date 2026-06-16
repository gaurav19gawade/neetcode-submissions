class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] box = new HashSet[9];



        for(int i = 0; i < board.length; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.'){
                    int boxLocation = (i/3)*3+(j/3);
                    char currChar = board[i][j];


                if(rows[i].contains(currChar) || cols[j].contains(currChar) || box[boxLocation].contains(currChar)){
                    return false;
                }

                rows[i].add(currChar);
                cols[j].add(currChar);
                box[boxLocation].add(currChar);

                }
            }
        }
        return true;
    }
}
