class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    freshOranges +=1;
                }

                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }

            }
        }

        int minutes = 0;

        while(!queue.isEmpty() && freshOranges > 0){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int[] current = queue.poll();
                for(int[] dir: directions){
                    int nr = dir[0] + current[0];
                    int nc = dir[1] + current[1];

                    if(nr > -1 && nr < grid.length && nc > -1 && nc < grid[0].length && grid[nr][nc] == 1){
                        queue.offer(new int[]{nr,nc});
                        grid[nr][nc] = 2;
                        freshOranges--;
                    }
                }
            }
            minutes++;
        }

        return freshOranges != 0 ? -1: minutes;
    }
}
