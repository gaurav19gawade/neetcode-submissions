class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        Deque<Integer> queue = new LinkedList<>();

        for(int[] prereq: prerequisites){
            map.computeIfAbsent(prereq[1], ignored -> new ArrayList<>()).add(prereq[0]);
            inDegree[prereq[0]]++;
        }

        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        int taken = 0;

        while(!queue.isEmpty()){
            int course = queue.poll();
            taken++;

            for(int n: map.getOrDefault(course, new ArrayList<>())){
                if(--inDegree[n] == 0) queue.offer(n);
            }
        }
        
        return taken == numCourses;
    }
}
