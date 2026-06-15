class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String, List<String>> map = new HashMap<>(); 
        for(String s: strs){
            int[] order = new int[26];
            for(char c: s.toCharArray()){
                order[c-'a']++;
            }
            map.computeIfAbsent(Arrays.toString(order), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
