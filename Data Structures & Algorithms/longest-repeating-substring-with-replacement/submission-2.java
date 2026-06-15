class Solution {
    public int characterReplacement(String s, int k) {
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int freqOfRepeatingChar = 0, start = 0;
        int maxWindowSize = 0;

        while(end < s.length()){
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)+1);

            if(map.get(s.charAt(end)) > freqOfRepeatingChar){
                freqOfRepeatingChar = map.get(s.charAt(end));
            }

            if((end-start+1) - freqOfRepeatingChar <= k){
                maxWindowSize = Math.max(maxWindowSize, end-start+1);
            }else{
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                start++;
            }
            end++;
        }
        return maxWindowSize;
    }
}
