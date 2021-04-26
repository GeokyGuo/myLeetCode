package secondRound.Week7.第16课_位运算;

public class L231_Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        int b = n & (n - 1);
        return n > 0 && b == 0;
    }
}
