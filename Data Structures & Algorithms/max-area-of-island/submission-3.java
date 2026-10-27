class Solution {
    int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(dfs(i,j,grid), maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int row, int col, int[][] grid){
        grid[row][col] = 0;
        int area = 1;
        for(int[] dir: direction){
            int nr = dir[0] + row;
            int nc = dir[1] + col;

            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1){
                area += dfs(nr, nc, grid);
            }
        }

        return area;
    }
}
