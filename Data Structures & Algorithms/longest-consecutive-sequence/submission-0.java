class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> result = new HashSet<>();
        int len = 0;
        int maxSeq = 0;
        for(int n: nums){
            result.add(n);
        }

        for(int n: nums){
            if(!result.contains(n-1)){
                len = 0;
                while(result.contains(n+len)){
                    len +=1;
                }
                maxSeq = Math.max(maxSeq, len);
            }
        }
        return maxSeq;
    }
}
