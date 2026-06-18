class Solution {
    public int trap(int[] height) {
        int[] rightArr = new int[height.length];
        int[] leftArr = new int[height.length];
        int result = 0;

        leftArr[0] = height[0];
        rightArr[rightArr.length-1] = height[height.length-1];

        for(int i = 1; i < leftArr.length; i++){
            leftArr[i] = Math.max(leftArr[i-1],height[i]);
        }
 
        for(int i = rightArr.length-2; i >=0; i--){
            rightArr[i] = Math.max(rightArr[i+1],height[i]);
        }

        for(int i = 0; i < height.length; i++){
            result += (Math.min(rightArr[i], leftArr[i]) - height[i]);
        }
        return result;
    }
}
