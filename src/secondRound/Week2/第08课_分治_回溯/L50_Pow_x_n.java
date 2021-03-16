package secondRound.Week2.第08课_分治_回溯;

public class L50_Pow_x_n {
    public static void main(String[] args) {
        double s = myPow2(1.0,-2147483648);
        System.out.println(s);
    }

    public double myPow(double x, int n) {
        double re = myPow1(x, Math.abs(n));

        return n > 0 ? re : 1.0 / re;
    }

    public double myPow1(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double temp = myPow1(x, n / 2);
        if (n % 2 == 0) {
            x = temp * temp;
        } else {
            x = temp * temp * x;
        }
        return x;
    }


    //参考

    public static double myPow2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }


    //两个点
    //为什么 要使用long类型，因为 -2^（32） 变成 2^(32) 会越界， int  -2^（32）~~~2^(32)-1   -1都是在后边
    //为什么递归一定要到  N==0   而不能 N==1 return x；  因为N/2 递归的过程中不一定遇到 N==1， 也有可能 4 2 0，把N==1 跳过了，就会一直递归，出现栈溢出

}
