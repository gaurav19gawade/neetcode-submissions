class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            int[] arr = new int[26];

            for(char c: s.toCharArray()){
                arr[c- 'a']++;
            }

            String temp = Arrays.toString(arr);
            map.computeIfAbsent(temp, ignored -> new ArrayList<>()).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());
        return result;
    }
}
