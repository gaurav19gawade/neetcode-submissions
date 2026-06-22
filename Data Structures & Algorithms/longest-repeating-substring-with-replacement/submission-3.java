class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        int window = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            freq.merge(s.charAt(right),1,Integer::sum);
            maxFreq = Math.max(maxFreq, freq.get(s.charAt(right)));

            if((right-left+1) - maxFreq <=k){
                window = Math.max((right-left+1),window);
            }else{
                freq.merge(s.charAt(left),-1,Integer::sum);
                left++;
            }
        }

        return window;
    }
}
