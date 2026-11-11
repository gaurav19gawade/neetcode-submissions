class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] result = new int[k];

        for(int n: nums){
            freq.merge(n, 1, Integer::sum);
        }

        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            map.computeIfAbsent(entry.getValue(), ignored -> new ArrayList<>()).add(entry.getKey());
        }

        int index = nums.length;

        while(index >= 0){
            List<Integer> list = map.getOrDefault(index, new ArrayList<>());
            for(int n: list){
                if(k > 0){
                    result[--k] = n;
                }
            }
            index--;
        }
        return result;
    }
}
