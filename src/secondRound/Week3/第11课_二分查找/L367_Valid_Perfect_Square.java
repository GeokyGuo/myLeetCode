package secondRound.Week3.第11课_二分查找;

public class L367_Valid_Perfect_Square {
    public boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num;

        while(left < right){
            long mid = left + (right - left) / 2;

            if(mid * mid < num){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return (int)(left * left) == num;
    }
}
