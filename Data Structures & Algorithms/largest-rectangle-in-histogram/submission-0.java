class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] previous = previousImmediateSmaller(heights);
        int[] nextImmediate = nextImmediateSmaller(heights);
        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i < heights.length; i++){
            int width = nextImmediate[i] - previous[i] - 1;
            int area = width * heights[i];
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    private int[] previousImmediateSmaller(int[] heights){
        Deque<Integer> stack = new ArrayDeque<>();
        int[] previous = new int[heights.length];
        stack.push(-1);

        for(int i = 0; i < heights.length; i++){
            while(stack.peek() != -1 && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            previous[i] = stack.peek();
            stack.push(i);
        }
        return previous;
    }

    private int[] nextImmediateSmaller(int[] heights){
        Deque<Integer> stack = new ArrayDeque<>();
        int[] nextImmediate = new int[heights.length];
        stack.push(nextImmediate.length);

        for(int i = heights.length-1; i >=0; i--){
            while(stack.peek() != nextImmediate.length && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            nextImmediate[i] = stack.peek();
            stack.push(i);
        }
        return nextImmediate;
    }    
}
