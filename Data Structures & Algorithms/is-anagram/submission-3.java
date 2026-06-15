class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            mapS.merge(s.charAt(i),1,Integer::sum);
        }

        for(int j = 0; j < s.length(); j++){
            mapT.merge(t.charAt(j),1,Integer::sum);
        }

        for(Map.Entry<Character, Integer> entry: mapS.entrySet()){
            if(!(mapT.containsKey(entry.getKey()) && Objects.equals(entry.getValue(), mapT.get(entry.getKey())))){
                return false;
            }
        }

        return true;
    }
}
