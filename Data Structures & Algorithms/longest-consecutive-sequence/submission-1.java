class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxLength = 0;


        for(int n: nums){
            set.add(n);
        }

        for(int n: nums){
            if(!set.contains(n-1)){
                int currentLength = 0;
                while(set.contains(n)){
                    currentLength+=1;
                    n+=1;
                }
                maxLength = Math.max(maxLength,currentLength);
            }
        }
        return maxLength;
    }
}
