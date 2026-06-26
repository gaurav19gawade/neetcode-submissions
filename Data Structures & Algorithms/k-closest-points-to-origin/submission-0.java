class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap: farthest point is at the top, so we can evict it
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (b[0] - a[0])  // compare by squared distance descending
        );

        for (int[] point : points) {
            int x = point[0], y = point[1];
            int distSq = x * x + y * y;  // no sqrt needed — avoids precision loss
            pq.offer(new int[]{distSq, x, y});
            if (pq.size() > k) {
                pq.poll();  // evict the farthest point
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            int[] el = pq.poll();
            result[i][0] = el[1];
            result[i][1] = el[2];
            i++;
        }
        return result;
    }
}