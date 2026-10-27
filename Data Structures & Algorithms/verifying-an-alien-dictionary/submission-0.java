class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i), i);
        }

        for(int i = 1; i < words.length; i++){
            String firstWord = words[i-1];
            String secondWord = words[i];

            for(int j = 0; j < firstWord.length(); j++){
                if(j == secondWord.length()) return false;

                char first = firstWord.charAt(j);
                char second = secondWord.charAt(j);

                if(map.get(first) > map.get(second)){
                    return false;
                }else if(map.get(first) < map.get(second)){
                    break;
                }
            }
        }
        
        return true;
    }
}