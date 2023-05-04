package 复习一轮;

public class test11 {
    //69
    public int mySqrt(int x) {
        long left = 0;
        long right = x;

        while (left < right) {
            long mid = left + (right - left + 1) / 2;//todo
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return (int) left;
    }

    //367
    public boolean isPerfectSquare(int num) {

        int left = 0;
        int right = num;

        while (left < right) {
            int mid = left + (right - left + 1) / 2; //todo
            if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid;
            }

        }
        return left * left == num;
    }

    //74
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        if (row == -1) return false;
        return findCol(matrix, row, target);
    }

    private boolean findCol(int[][] matrix, int row, int target) {
        int left = 0;
        int right = matrix[row].length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return matrix[row][left] == target;
    }


    private int findRow(int[][] matrix, int target) {
        final int zore = 0;
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (matrix[mid][zore] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

}
