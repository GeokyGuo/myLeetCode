package firstRound.L69_SqrtX;

public class Solution0815 {

    public static void main(String[] args) {
        int x = 7;
        int re = mySqrt(x);
        System.out.println(re);
    }

    public static int mySqrt(int x) {
        long left = 0;
        long right = x;

        while (left < right) {
            long mid = left + right +1 >>> 1;

            long mul = mid * mid;
            if (mul > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return (int)left;
    }
}
