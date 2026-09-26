class Solution {
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        int noOfIsland = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    noOfIsland++;
                }
            }
        }
        return noOfIsland;
    }

    private void dfs(int row, int col, char[][] grid){
        for(int[] dir: directions){
            int nr = dir[0] + row;
            int nc = dir[1] + col;

            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1'){
                grid[nr][nc] = '0';
                dfs(nr, nc, grid);
            }
        }
    }
}
