package secondRound.Week5.L第12课_动态规划;

import java.util.Arrays;

public class L213_House_Robber_II {
    public int rob(int[] nums) {
        //环状问题拆解为两个线性问题
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)), myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    int myRob(int[] nums){
        int pre = 0, cur = 0, temp;

        for(int num: nums){
            temp = cur;
            cur = Math.max(cur, pre + num);
            pre = temp;
        }
        return cur;
    }
}


//Arrays.copyOfRange([],闭，开)  复制数组，前闭后开