class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for(int[] courses: prerequisites){
            int pre = courses[1];
            int course = courses[0];
            graph.computeIfAbsent(pre, ignored -> new ArrayList<>()).add(course);
            indegree[course]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty()){
            int u = queue.poll();
            result[index++] = u;

            for(int neigh: graph.getOrDefault(u, new ArrayList<>())){
                if(--indegree[neigh] == 0){
                    queue.offer(neigh);
                }
            }
        }

        return index == numCourses;
    }
}
