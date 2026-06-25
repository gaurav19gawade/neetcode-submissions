class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];
        int index = 0;

        for(int i = 0; i < nums.length; i++){
            int n = nums[i];

            while(!deque.isEmpty() && n > nums[deque.peekLast()]){
                deque.pollLast();
            }

            deque.addLast(i);

            if((i - k + 1) > deque.peekFirst()){
                deque.pollFirst();
            }

            if(i >= k-1){
                result[index] = nums[deque.peekFirst()];
                index++;
            }
        }

        return result;
    }
}
