class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length()
                && w1.substring(0, minLen).equals(w2.substring(0, minLen)))
                return "";

            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (!adj.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.merge(w2.charAt(j), 1, Integer::sum);
                    }
                    break;
                }
            }
        }

        Deque<Character> queue = new ArrayDeque<>();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0)
                queue.offer(c);
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);

            for (char ne : adj.getOrDefault(current, new HashSet<>())) {
                indegree.merge(ne, -1, Integer::sum);
                if (indegree.get(ne) == 0)
                    queue.offer(ne);
            }
        }

        if(result.length() != indegree.size()) return "";

        return result.toString();
    }
}
