package secondRound.Week5.第12课_动态规划;

public class L198_House_Robber {
    public int rob(int[] nums) {
        //定义子问题，就是定义状态，因为每一个状态对应一个子问题
        //子问题就是 前k个房屋怎么偷到最大值
        //定义状态转移方程 f(k) = max（f(k-1),f(k-2) + H (k)）；
        //压缩状态空间
        if(nums == null || nums.length == 0) {
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2 ; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length -1];
    }

//压缩状态空间
    public int rob2(int[] nums) {
        //定义子问题，就是定义状态，因为每一个状态对应一个子问题
        //子问题就是 前k个房屋怎么偷到最大值
        //定义状态转移方程 f(k) = max（f(k-1),f(k-2) + H (k)）；
        //压缩状态空间
        if(nums == null || nums.length == 0) {
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }
        int pre = nums[0];
        int last = Math.max(nums[0], nums[1]);
        int temp;
        for(int i = 2 ; i < nums.length; i++){
            temp = last;
            last = Math.max(last, pre + nums[i]);
            pre = temp;
        }

        return last;
    }
}
