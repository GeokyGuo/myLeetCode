package secondRound.Week3.第10课_贪心算法;

public class L55_Jump_Game {

    //从前往后
    public boolean canJump(int[] nums) {
        int position = 0;

        for(int i = 0; i < nums.length; i++){
            if(i <= position){
                position = (nums[i] + i) > position ? nums[i] + i : position;
            }else{
                break;
            }
        }
        return position >= (nums.length - 1);
    }



//从后往前
    public boolean canJump2(int[] nums) {
        int position = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if((nums[i] + i) >= position){
                position = i;
            }
        }
        return position == 0;

    }
}

//最大位置之前都是可达的点