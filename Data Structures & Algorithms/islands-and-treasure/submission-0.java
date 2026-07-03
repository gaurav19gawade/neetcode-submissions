class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i =0; i < grid.length; i++){
            for(int j = 0; j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        
        while(!queue.isEmpty()){
            int[] currentNode = queue.poll();
            for(int[] direction: directions){
                int nr = currentNode[0] + direction[0];
                int nc = currentNode[1] + direction[1];

                if(nr > -1 && nr < grid.length && nc > -1 && nc < grid[0].length && grid[nr][nc] == Integer.MAX_VALUE){
                    grid[nr][nc] = grid[currentNode[0]][currentNode[1]] +1;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
