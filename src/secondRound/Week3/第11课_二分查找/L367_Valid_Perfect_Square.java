package secondRound.Week3.第11课_二分查找;

public class L367_Valid_Perfect_Square {
    public boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int) (left * left) == num;
    }

    //这个题 在变换搜索空间时，用大于 或者  用小于  都是可以的。


    public boolean isPerfectSquare1(int num) {

        long left = 0;
        long right = num;

        while (left < right) {
            long mid = left + (right - left + 1) / 2; //todo
            if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid;
            }

        }
        return (int) left * left == num;
    }
}
