package secondRound.Week5.第12课_动态规划;

public class L64_Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        //定义状态， dp i j 代表当前走到当前格子的路径和最小
        //状态转移， dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + grid[i][j]
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];

        for(int i = 2; i < dp[0].length; i++){
            dp[0][i] = 200;
        }
        for(int i = 2; i < dp.length; i++){
            dp[i][0] = 200;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[grid.length][grid[0].length];
    }
}

//初始化两种方案，一种是在外框加一层，
//还有一种是  第一行，和第一列 直接累加进行初始化就好
