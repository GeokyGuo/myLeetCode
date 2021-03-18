package secondRound.Week5.第12课_动态规划;

public class L53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        //定义状态 以i结尾的 最大子序列的和
        //状态转移 di = d（i-1）+ i if di-1 > 0 else
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
        }
        int max = nums[0];
        for(int sum : dp){
            max = max > sum ? max : sum;
        }
        return max;
    }
}
//看到这终于明白了这道题的动态规划的思路。之前的题，是已经选好了dp[i-1]，然后来考虑要不要选第i个值。这道题是一定要选第i个值，然后再考虑要不要选第dp[i-1]。
//态规划的状态定义很重要，类似的子序列的问题，以什么什么结尾，是一个重要的、常见的状态定义。