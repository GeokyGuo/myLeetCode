package secondRound.Week1.第03课_数组_链表_跳表.homework;

public class L26_RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int re = removeDuplicates1(nums);
        System.out.println(re);

    }
    //自己第一遍，可以不需要temp， 因为有序，本质是只要和 新数组的最后一位不想等，就可以插入

    //这道题，相对简单，  不需要花费很多时间
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 1;
        int j = 1;
        int temp = nums[0];
        while (j < nums.length) {
            if (nums[j] != temp) {
                nums[i++] = nums[j++];
                temp = nums[i - 1];
            } else {
                j++;
            }
        }
        return i;
    }


    //复习
    public static int removeDuplicates1(int[] nums) {
        int i = 1, k = 0;

        while (i < nums.length) {
            if (nums[i] > nums[k]) {
                nums[++k] = nums[i++];
            } else {
                i++;
            }
        }
        return k + 1;
    }
}
