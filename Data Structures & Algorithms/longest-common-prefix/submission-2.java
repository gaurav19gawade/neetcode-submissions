class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String result = strs[0];
        for (int i = 0; i < result.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || result.charAt(i) != strs[j].charAt(i)) {
                    return result.substring(0,i);
                }
            }
        }
        return result;
    }
}