class Solution {
    int ROW = 0;
    int COL = 0;
    public int islandPerimeter(int[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(grid[i][j] == 1){
                    return bfs(i,j, grid, new boolean[ROW][COL]);
                }
            }
        }

        return 0;
    }
    

    public int bfs(int r, int c, int[][] grid, boolean[][] visited){
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        int perimeter = 0;

        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{r,c});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            visited[current[0]][current[1]] = true;
            for(int[] dir: direction){
                int nr = dir[0] + current[0];
                int nc = dir[1] + current[1];

                if(nr < 0 || nr >= ROW || nc < 0 || nc >= COL || grid[nr][nc] == 0){
                    perimeter++;
                }else if(!visited[nr][nc]){
                    queue.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
        }

        return perimeter;
    }
}