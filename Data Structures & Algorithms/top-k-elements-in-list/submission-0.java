class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for(int n: nums){
            count.put(n, count.getOrDefault(n, 0)+1);
        }


        PriorityQueue<Integer> heap = new PriorityQueue((a, b) -> count.get(a) - count.get(b));

        for(int n: count.keySet()){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] result = new int[k];
        for(int i = k-1; i >= 0; i--){
            result[i] = heap.poll();
        }

        return result;
    }
}
