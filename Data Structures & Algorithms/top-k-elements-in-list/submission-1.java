class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for(int n: nums){
            map.merge(n,1,Integer::sum);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        pq.addAll(map.entrySet());

        while(pq.size() > k){
            pq.poll();
        }

        while(!pq.isEmpty() && k > 0){
            result[--k] = pq.poll().getKey();
        }
        return result;
    }
}
