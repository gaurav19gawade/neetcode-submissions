class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0,1);
        int total = 0;
        int count = 0;

        for(int n: nums){
            total += n;

            int required = total - k;

            if(map.containsKey(required)){
                count += map.get(required);
            }

            map.put(total, map.getOrDefault(total,0)+1);
        }

        return count;
    }
}