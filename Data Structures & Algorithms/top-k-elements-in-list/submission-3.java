class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];
        int[] result = new int[k];
        int idx = 0;

        for(int n: nums){
            map.merge(n, 1, Integer::sum);
        }

        for(var entry: map.entrySet()){
            int value = entry.getValue();
            if(bucket[value] == null){
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(entry.getKey());
        }

        for(int f = bucket.length-1; f >=0 && idx < k; f--){
            if(bucket[f] != null){
                for(int i: bucket[f]){
                    result[idx++] = i;
                    if(idx == k){
                        break;
                    }
                }
            }

        }
        return result;
    }
}
