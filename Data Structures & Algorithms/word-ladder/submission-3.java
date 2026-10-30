class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Deque<String> queue = new LinkedList<>();
        HashSet<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        int level = 1;

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        queue.offer(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                String newWord = queue.poll();

                if (newWord.equals(endWord)) {
                    return level;
                }

                char[] currWord = newWord.toCharArray();

                for (int i = 0; i < currWord.length; i++) {
                    char temp = currWord[i];

                    for (char a = 'a'; a <= 'z'; a++) {
                        currWord[i] = a;
                        String searchString = new String(currWord);
                        if (!visited.contains(searchString) && wordSet.contains(searchString)) {
                            queue.offer(searchString);
                            visited.add(searchString);
                        }
                    }
                    currWord[i] = temp;
                }
            }
            level++;
        }
        return 0;
    }
}
