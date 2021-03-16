package secondRound.Week3.第11课_二分查找;

public class L69_Sqrt_X {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;

        while(left < right){
            int mid = left + (right - left + 1) / 2;

            if(mid * mid > x){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        return left;
    }
}


