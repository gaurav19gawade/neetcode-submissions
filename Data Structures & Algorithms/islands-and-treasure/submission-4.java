public class Solution {

    private final int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    private final int INF = Integer.MAX_VALUE;

    public void islandsAndTreasure(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // 1. Add ALL treasures to the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        // 2. Multi-source BFS
        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] dir : directions) {

                int nr = row + dir[0];
                int nc = col + dir[1];

                // Invalid position
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }

                // Only visit unvisited empty rooms
                if (grid[nr][nc] != INF) {
                    continue;
                }

                // Neighbor is one step farther from a treasure
                grid[nr][nc] = grid[row][col] + 1;

                queue.offer(new int[]{nr, nc});
            }
        }
    }
}