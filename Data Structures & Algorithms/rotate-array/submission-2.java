class Solution {
    public void rotate(int[] nums, int k) {

      /**
      [8,7,6,5,4,3,2,1]
      [5,6,7,8,4,3,2,1]
      [5,6,7,8,1,2,3,4]
      **/ 
      int n = nums.length-1;
      k = k % nums.length;
      System.out.println(k);
      rotatehelper(nums, 0, n);
      rotatehelper(nums, 0, k-1);
      rotatehelper(nums, k, n);
    }

    private void rotatehelper(int[] nums, int left, int right){
        while(left <= right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}