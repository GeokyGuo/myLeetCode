package secondRound.Week1.第03课_数组_链表_跳表.array;

public class L283_MoveZeroes {
    public static void main(String[] args) {

    }

    //方法还可以再进一步简化，用交换的方式
    public static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        for (; i < nums.length; i++) {
            //判断是否为零  非零的话，用j下标重构数组
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j < nums.length; j++) {
            //剩余长度置为0
            nums[j] = 0;
        }
    }

    //复习
    public static void moveZeroes1(int[] nums) {
        int k = 0;

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                if (k != i) {
                    nums[i] = 0;
                }
                i++;
                k++;
            } else {
                i++;
                continue;
            }

        }
    }


}