package secondRound.Week8.第20课_字符串算法;

public class L32_Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {
        // dp i  是以i为结尾的 最长有效字符串
        // si = "("  dp i = 0
        // si =  ")"
        // si-1 = "("  dp i = dp i-2 + 2
        // si-1 = ")"  si(i - dp[i-1]) = "("   dp i = dp i-1  + 2 + dp [i - dp[i-1] - 1];
        if (s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(')
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                else {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
