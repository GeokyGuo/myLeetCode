package L69_SqrtX;

public class Solution0719 {

    public static void main(String[] args) {
        int x = 10;
        int re = mySqrt(x);
        System.out.println(re);
    }

    public static int mySqrt(int x) {
        long left = 0;
        long right = x;


        while (left < right) {
            long mid = left + (right - left + 1) / 2;//待定
            long mul = mid * mid;
            if (mul > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }
}
