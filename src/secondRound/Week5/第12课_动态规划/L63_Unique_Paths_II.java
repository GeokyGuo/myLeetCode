package secondRound.Week5.第12课_动态规划;

public class L63_Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;

        for(int i = 1; i < m + 1; i++ ){
            for(int j = 1; j < n + 1; j++){
                if(obstacleGrid[i-1][j-1] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }else{
                    dp[i][j] = 0;
                }

            }
        }

        return dp[m][n];
    }


    ///
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }else if(j > 0){
                    dp[j] += dp[j - 1];
                }
            }
        }


        return dp[n - 1];
    }
}
//正常初始化，初始化行和列
//扩列法初始化，好处是让代码统一，不用专门去初始化边界条件
//优化之后的动态规划一个数组