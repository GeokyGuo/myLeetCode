package secondRound.Week3.第10课_贪心算法;

public class L45_Jump_Game_II {
    public static void main(String[] args) {
        int[] nums = {2,3,1,10,4,1,1,1,1,1,1};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int maxposition = 0;
        int end = 0;
        int step = 0;
        for(int i = 0; i < nums.length - 1; i++){
            maxposition = Math.max(nums[i] + i, maxposition);
            if(i == end){
                end = maxposition;
                step++;
            }
        }
        return step;
    }


    public int jump2(int[] nums) {
        int maxposition = nums.length -1;
        int step = 0;

        while(maxposition != 0){
            for(int i = 0; i < nums.length - 1; i++){
                if(nums[i] + i >= maxposition){
                    maxposition = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

}


//maxposition是下一个 要遍历点的终点