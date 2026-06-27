class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        int[] freq = new int[26];

        for(char c: tasks){
            freq[c-'A']++;
        }

        for(int i: freq){
            if(i > 0){
                maxHeap.offer(i);
            }
        }

        Queue<int[]> cooldown = new LinkedList<>();
        int cycles = 0;

        while(!maxHeap.isEmpty() || !cooldown.isEmpty()){
            cycles++;

            if(!maxHeap.isEmpty()){
                int count = maxHeap.poll() - 1;
                if(count > 0){
                    cooldown.offer(new int[]{count, cycles + n});
                }
            }

            if(!cooldown.isEmpty() && cooldown.peek()[1] == cycles){
                maxHeap.offer(cooldown.poll()[0]);
            }
        }
        return cycles;
    }
}