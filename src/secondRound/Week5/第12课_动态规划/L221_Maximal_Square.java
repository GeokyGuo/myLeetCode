package secondRound.Week5.第12课_动态规划;

public class L221_Maximal_Square {
    public int maximalSquare(char[][] matrix) {
        //子问题，状态定义，dp[i][j] 是matrix[i][j] 为顶点的最大正方形
        //转移方程， if matrix[i][j] != 0 dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1    else dp[i][j] = 0;

        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
            result = Math.max(dp[i][0], result);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] - '0';
            result = Math.max(dp[0][i], result);
        }
        for (int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] - '0' != 0){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i -1][j]), dp[i][j - 1]) + 1;
                    result = Math.max(dp[i][j], result);
                }
            }
        }
        return result;
    }
}
