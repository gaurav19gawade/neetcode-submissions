class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        int matches = 0;
        int left = 0;
        int windowSize = Integer.MAX_VALUE;
        String result = "";

        for(Character c: t.toCharArray()){
            tMap.merge(c,1,Integer::sum);
        }

        for(int right = 0; right < s.length(); right++){
            sMap.merge(s.charAt(right),1,Integer::sum);

            if (tMap.containsKey(s.charAt(right)) && 
                tMap.get(s.charAt(right)).equals(sMap.get(s.charAt(right)))) {
                matches++;
            }

            while(matches == tMap.size()){
                Character leftChar = s.charAt(left);
                if(right-left+1 < windowSize){
                    windowSize = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                sMap.merge(leftChar, -1, Integer::sum);
                if(tMap.containsKey(s.charAt(left)) && tMap.get(s.charAt(left)) > sMap.get(s.charAt(left))){
                    matches--;
                }
                left++;
            } 
        }
        return result;
    }
}
