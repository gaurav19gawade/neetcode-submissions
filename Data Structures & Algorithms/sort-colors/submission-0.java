class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int current = 0;

        while (current <= right) {
            if (nums[current] == 0) {
                swap(current, left, nums);
                left++;
                current++;
            } else if (nums[current] == 2) {
                swap(right, current, nums);
                right--;
            } else {
                current++;
            }
        }
    }

    private void swap(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}