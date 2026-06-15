class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n: nums){
            map.merge(n, 1, Integer::sum);
            if(map.get(n) == 2){
                return true;
            }
        }

        // for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        //     if(entry.getValue() == 2){
        //         return true;
        //     }
        // }

        return false;
    }
}