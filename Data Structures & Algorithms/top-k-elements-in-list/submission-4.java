class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int[] result = new int[k];

        for (int n : nums) {
            freq.merge(n, 1, Integer::sum);
        }

        HashMap<Integer, List<Integer>> freqCollection = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            freqCollection.computeIfAbsent(entry.getValue(), ignored -> new ArrayList<>())
                .add(entry.getKey());
        }

        int maxIndex = nums.length;

        for (int i = maxIndex; i >= 0; i--) {
            if (freqCollection.containsKey(i)) {
                List<Integer> numbers = freqCollection.getOrDefault(i, new ArrayList<>());
                int index = numbers.size()-1;
                while (k > 0 && index >= 0) {
                    result[--k] = numbers.get(index--);
                }
            }
        }
        return result;
    }
}
