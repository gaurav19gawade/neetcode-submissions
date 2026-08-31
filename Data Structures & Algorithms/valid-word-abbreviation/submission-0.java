class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int m = word.length(), n = abbr.length();
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (abbr.charAt(j) == '0')
                return false;

            if (Character.isLetter(abbr.charAt(j))) {
                if (word.charAt(i) == abbr.charAt(j)) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            } else {
                int subLen = 0;
                while (j < n && Character.isDigit(abbr.charAt(j))) {
                    subLen = subLen * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += subLen;
            }
        }

        return i == m && j == n;
    }
}