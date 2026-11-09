class Solution {
    public int[] getConcatenation(int[] nums) {
        int size = nums.length * 2;
        int[] result = new int[size];
        int index = 0;

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < nums.length; j++){
                result[index] = nums[j];
                index++;
            }
        }
        return result;
    }
}