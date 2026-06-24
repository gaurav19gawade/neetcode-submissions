class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.isEmpty()) return true;
        if (s2.isEmpty() || s2.length() < s1.length()) return false;

        HashMap<Character, Integer> s1Freq = new HashMap<>();
        HashMap<Character, Integer> s2Freq = new HashMap<>();
        int matches = 0;

        // Build s1Freq and first window of s2Freq
        for (int i = 0; i < s1.length(); i++) {
            s1Freq.merge(s1.charAt(i), 1, Integer::sum);
            s2Freq.merge(s2.charAt(i), 1, Integer::sum);
        }

        // Check matches for first window
        for (Character c : s1Freq.keySet()) {
            if (s1Freq.get(c).equals(s2Freq.get(c))) {
                matches++;
            }
        }

        if (matches == s1Freq.size()) return true;

        // Slide the window
        for (int right = s1.length(); right < s2.length(); right++) {
            int left = right - s1.length();

            // Add incoming character
            char inChar = s2.charAt(right);
            s2Freq.merge(inChar, 1, Integer::sum);
            if (s1Freq.containsKey(inChar)) {
                if (s2Freq.get(inChar).equals(s1Freq.get(inChar))) {
                    matches++;
                } else if (s2Freq.get(inChar) == s1Freq.get(inChar) + 1) {
                    matches--;
                }
            }

            // Remove outgoing character
            char outChar = s2.charAt(left);
            if (s1Freq.containsKey(outChar)) {
                if (s2Freq.get(outChar).equals(s1Freq.get(outChar))) {
                    matches--;
                } else if (s2Freq.get(outChar) == s1Freq.get(outChar) + 1) {
                    matches++;
                }
            }

            s2Freq.merge(outChar, -1, Integer::sum);
            if (matches == s1Freq.size()) return true;
        }

        return false;
    }
}