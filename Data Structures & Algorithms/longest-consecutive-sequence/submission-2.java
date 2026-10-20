class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for(int n: nums){
            set.add(n);
        }

        for(int n: nums){
            if(!set.contains(n-1)){
                int length = 0;
                while(set.contains(n + length)){
                    length++;
                }
                count = Math.max(length, count);
            }
        }
        return count;
    }
}
