package secondRound.Week5.第12课_动态规划;

public class L32_Longest_Valid_Parentheses {
    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s) {
        //dp i 是以i为结尾的有效括号 最长长度
        //s i == '('  dp i = 0      //这个方程之前想错了
        //s i == ')'
        // s i - 1 = '（'   dp i = dp i-2   +  2
        // s i - 1 = ')'
        //  s (i - 1 - dp[i-1]) == '('  di = dp i -1    + 2    + dp[i-dp[i-1]-2]
        if(s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int max = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                }else {
                    if(i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                        dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1]  >= 2) ?  dp[i - dp[i - 1] - 2] : 0);
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
