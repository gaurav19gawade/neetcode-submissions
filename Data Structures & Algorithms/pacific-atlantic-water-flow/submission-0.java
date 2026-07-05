class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rowl = heights.length;
        int coll = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();

        boolean[][] pacific = new boolean[rowl][coll];
        boolean[][] atlantic = new boolean[rowl][coll];

        for(int i = 0; i < rowl; i++){
            dfs(i,0,pacific,heights);
            dfs(i,coll-1,atlantic,heights);
        }

        for(int i = 0; i < coll; i++){
            dfs(0,i,pacific, heights);
            dfs(rowl-1,i,atlantic,heights);
        }

        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                if(atlantic[i][j] && pacific[i][j]){
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights){
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        ocean[r][c] = true;

        for(int[] dir: directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr > -1 && nr < ocean.length && nc > -1 && nc < ocean[0].length && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                dfs(nr, nc, ocean, heights);
            }
        }
    }
}
