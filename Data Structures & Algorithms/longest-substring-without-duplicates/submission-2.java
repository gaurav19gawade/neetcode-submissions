class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxSize = 0;


        while(right < s.length()){
            if(!seen.contains(s.charAt(right))){
                seen.add(s.charAt(right));
                maxSize = Math.max(right-left+1,maxSize); 
                right++;
            }else{
                seen.remove(s.charAt(left));
                left++;
            }
        }
        return maxSize;
    }
}
