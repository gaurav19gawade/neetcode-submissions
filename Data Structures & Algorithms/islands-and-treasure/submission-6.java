class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] directons = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
            }
        }

        if(queue.isEmpty()) return;

        while(!queue.isEmpty()){
            int[] current = queue.poll();

            for(int[] dir: directons){
                int nr = dir[0] + current[0];
                int nc = dir[1] + current[1];

                if(nc < 0 || nc >= COLS || nr < 0 || nr >= ROWS || grid[nr][nc] != Integer.MAX_VALUE){
                    continue;
                }

                grid[nr][nc] = grid[current[0]][current[1]] + 1;
                queue.add(new int[]{nr,nc});
            }
        }
    }
}
