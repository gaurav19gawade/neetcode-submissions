class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, bfs(grid, i, j));
                }
            }
        }
        return maxArea;
        
    }

    public int bfs(int[][] grid, int currRow, int currCol){
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{currRow, currCol});
        grid[currRow][currCol] = 0;
        int area = 1;

        while(!queue.isEmpty()){
            int[] currNode = queue.poll();

            for(int[] dir: directions){
                int x = dir[0] + currNode[0];
                int y = dir[1] + currNode[1];

                if(x > -1 && x < grid.length && y > -1 && y < grid[0].length && grid[x][y] == 1){
                    area+=1;
                    queue.offer(new int[]{x,y});
                    grid[x][y] = 0;
                }
            }
        }
        return area;
    }
}
