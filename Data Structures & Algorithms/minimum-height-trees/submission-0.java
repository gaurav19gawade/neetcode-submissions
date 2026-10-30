class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Arrays.asList(0);
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            graph.computeIfAbsent(u, value -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, value -> new ArrayList<>()).add(u);

            indegree[u]++;
            indegree[v]++;
        }

        Deque<Integer> leaves = new ArrayDeque<>();
        int remainingNodes = n;

        for(int i = 0; i < n; i++){
            if(indegree[i] == 1){
                leaves.offer(i);
            }
        }

        System.out.println(leaves);

        while(remainingNodes > 2){
            int size = leaves.size();
            remainingNodes -= size;

            for(int i = 0; i < size; i++){
                int node = leaves.poll();

                for(int neigh: graph.get(node)){
                    indegree[neigh]--;
                    if(indegree[neigh] == 1){
                        leaves.offer(neigh);
                    }
                }
            }
        }

        return new ArrayList<>(leaves);
    }
}