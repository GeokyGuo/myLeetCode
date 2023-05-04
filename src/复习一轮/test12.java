package 复习一轮;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class test12 {
    //62
    public int uniquePaths(int m, int n) {
        //状态  dij 是达到某个格子的路径数目
        //状态方程  dij = d i j-1 + d i-1 j

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    //63

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //状态  dij 是达到某个格子的路径数目
        //状态方程       ob[i][j] !=1 ? dij = d i j-1 + d i-1 j : dij = 0
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }


    //53
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //状态 di 以nums[i]结尾的最大和
        //转移方程  di = d i-1  >0  ?di-1 + nums[i] : nums[i]
        int[] dp = new int[nums.length];

        //初始状态
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    //322
    public int coinChange(int[] coins, int amount) {
        Deque<Integer> queue = new ArrayDeque<>();
        Arrays.sort(coins);

        boolean[] visited = new boolean[amount];
        queue.offer(0);

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int coin : coins) {
                    int can = poll + coin;

                    if (can == amount) {
                        return step;
                    }

                    if (can > amount) {
                        break;
                    }

                    if (!visited[can]) {
                        visited[can] = true;
                        queue.offer(can);
                    }
                }
            }
            step++;
        }
        return -1;
    }





}
