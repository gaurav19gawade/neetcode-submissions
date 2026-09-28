class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new LinkedList<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int freshOrange = 0;
        int totalMinutes = 0;
        boolean[][] visited = new boolean[ROWS][COLS];
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }

                if(grid[i][j] == 1){
                    freshOrange++;
                }
            }
        }

        if(freshOrange == 0){
            return totalMinutes;
        }

        while(!queue.isEmpty() && freshOrange > 0){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];
                visited[r][c] = true;

                for(int[] direction: directions){
                    int nr = r + direction[0];
                    int nc = c + direction[1];

                    if(nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && !visited[nr][nc] && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        freshOrange--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            totalMinutes++;
        }

        return freshOrange == 0 ?  totalMinutes : -1;
    }
}
