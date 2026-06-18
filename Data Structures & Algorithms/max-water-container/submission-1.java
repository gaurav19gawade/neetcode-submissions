class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maximumArea = 0;

        while(left < right){
            int h = Math.min(heights[left], heights[right]);
            int l = right - left;
            int area = h * l;
            maximumArea = Math.max(area, maximumArea);

            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }

        return maximumArea;
    }
}
