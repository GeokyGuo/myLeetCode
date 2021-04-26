package secondRound.Week7.第16课_位运算;

public class L338_Counting_Bits {
    // dp i的意思是 i这个数字的1的个数
    // dp i = dp i / 2 + i % 2
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i >>> 1] + (i % 2);
        }
        return dp;
    }
}
