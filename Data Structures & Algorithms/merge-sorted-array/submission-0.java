class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        System.out.println(Arrays.toString(nums1));
        while(m > 0 && n > 0){
            if(nums1[m-1] > nums2[n-1]){
                nums1[index] = nums1[m-1];
                m--;
            }else{
                nums1[index] = nums2[n-1];
                n--;
            }
            index--;
            System.out.println("value of m: " + m + " " +Arrays.toString(nums1));
        }

        while(n > 0){
            nums1[index] = nums2[n-1];
            index--;
            n--;
        }
    }
}