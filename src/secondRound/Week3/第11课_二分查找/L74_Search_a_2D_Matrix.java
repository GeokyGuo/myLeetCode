package secondRound.Week3.第11课_二分查找;

public class L74_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        while(left < right){
            int mid = left + (right - left + 1) / 2;

            if(matrix[mid][0] > target){ //要在 left -- right中 找到  恰好比 target小的元素，那么严格大于 target的mid肯定是不行的
                right = mid - 1;
            }else{
                left = mid;
            }
        }

        int row = left;
        left = 0;
        right = matrix[row].length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(matrix[row][mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return matrix[row][left] == target;
    }
}
