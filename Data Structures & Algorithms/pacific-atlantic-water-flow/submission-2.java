class Solution {
    int ROWS;
    int COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        for(int i = 0; i < COLS; i++){
            dfs(pacific, 0, i, heights[0][i], heights);
            dfs(atlantic, ROWS-1, i, heights[ROWS-1][i], heights);
        }

        for(int i = 0; i < ROWS; i++){
            dfs(pacific, i, 0, heights[i][0], heights);
            dfs(atlantic, i, COLS-1, heights[i][COLS-1], heights);
        }

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(boolean[][] visited, int r, int c, int previousheight, int[][] heights){
        if(r < 0 || r == ROWS || c < 0 || c == COLS || visited[r][c] || heights[r][c] < previousheight){
            return;
        }

        visited[r][c] = true;

        dfs(visited, r + 1, c, heights[r][c], heights);
        dfs(visited, r-1, c, heights[r][c], heights);
        dfs(visited, r, c+1, heights[r][c], heights);
        dfs(visited, r, c-1, heights[r][c], heights);
    }


}
