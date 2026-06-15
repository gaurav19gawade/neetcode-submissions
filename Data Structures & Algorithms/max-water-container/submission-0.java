class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int result = 0;

        while(left < right){
            int area = Math.min(heights[left], heights[right]) * (right-left);
            if(heights[left] <= heights[right]){
                left++;
            }else{
                right--;
            }
            result = Math.max(result, area);
        }
        return result;
    }
}
