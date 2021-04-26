package secondRound.Week7.第16课_位运算;

public class L190_Reverse_Bits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);

            n = n >>> 1;
        }
        return res;

    }
}
