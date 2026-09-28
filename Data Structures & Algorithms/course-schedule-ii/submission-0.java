class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int[] inDegree = new int[numCourses];
        int[] result = new int[numCourses];
        int index = 0;

        for(int[] p: prerequisites){
            map.computeIfAbsent(p[1], ignored -> new ArrayList<>()).add(p[0]);
            inDegree[p[0]]++;
        }

        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int course = queue.poll();
            result[index++] = course;

            for(int next: map.getOrDefault(course, new ArrayList<>())){
                if(--inDegree[next] == 0) queue.offer(next);
            }
        }

        return index == numCourses? result: new int[0];
    }
}
