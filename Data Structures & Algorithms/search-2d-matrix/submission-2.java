class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int lastCol = matrix[0].length-1;
        int bottom = matrix.length-1;


        while(top <= bottom){
            int row = (top + bottom) / 2;
            if(target > matrix[row][lastCol]){
                top = row + 1;
            } else if(target < matrix[row][0]){
                bottom = row -1;
            }else if(target >= matrix[row][0] && target <= matrix[row][lastCol]){
                return binarySearch(matrix[row], target);
            }
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;

        while(left<=right){
            int middle = (left + right) / 2;

            if(arr[middle] == target){
                return true;
            }else if(target > arr[middle]){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }
        return false;
    }
}
