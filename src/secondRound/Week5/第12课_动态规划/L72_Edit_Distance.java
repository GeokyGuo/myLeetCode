package secondRound.Week5.第12课_动态规划;

public class L72_Edit_Distance {
    public int minDistance(String word1, String word2) {
        // dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
        // 所以，
        // 当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
        // 当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
        // 其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 1; i <= word1.length(); i++){
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for(int i = 1; i <= word2.length(); i++){
            dp[0][i] = dp[0][i - 1] + 1;
        }

        for(int i = 1; i <= word1.length(); i++ ){
            for(int j = 1; j <= word2.length(); j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
