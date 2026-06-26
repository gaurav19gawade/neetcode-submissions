class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int n: nums){
            if(set.contains(n)) return true;
            set.add(n);
            // map.merge(n, 1, Integer::sum);
            // if(map.get(n) == 2){
            //     return true;
            // }
        }
        return false;
    }
}