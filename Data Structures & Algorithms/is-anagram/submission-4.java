class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sarr = new int[26];
        int[] tarr = new int[26];

        for(char c: s.toCharArray()){
            sarr[c - 'a']++;
        }

        for(char c: t.toCharArray()){
            tarr[c - 'a']++;
        }

        return Arrays.toString(sarr).equals(Arrays.toString(tarr));        
    }
}
