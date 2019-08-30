package L7_ReverseInteger;


public class Solution0830 {
    public static void main(String[] args) {
        int x = 1534236469;
        int a = reverse(x);
        System.out.println(a);
    }

    public static int reverse(int x) {

        long y = 0;
        long sum = 0;

        while (x != 0) {
            y = x % 10;
            sum = sum * 10 + y;
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }

        return (int) sum;
    }
}
