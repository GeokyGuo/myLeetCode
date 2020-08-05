package secondRound.Week1.第03课_数组_链表_跳表.homework;

import java.util.Arrays;

public class L189_RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate3(nums, 3);
        System.out.println(Arrays.toString(nums));

    }

    // 反转数组的方法
    public void rotate(int[] nums, int k) {
        k = k % nums.length;//这一点非常容易忘记
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end--] = nums[start];
            nums[start++] = temp;
        }
    }

    //环状替代法，重点记忆

    //    那么如何判断所有的分组都执行归位了呢？ 可以有两种方法来控制
//
//    第一种：我们就用最大公约数 mm 来控制外循环，代表总共有 mm 轮循环
//    第二种：由于nn个元素归位需要nn次交换，所以我们定义一个count代表交换次数，当 count = n 时完成
    public static void rotate1(int[] nums, int k) {
        int cout = 0;
        k %= nums.length;


        for (int start = 0; cout < nums.length; start++) {
            int cur = start;
            int pre = nums[cur];

            do {
                int next = (cur + k) % nums.length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                cur = next;
                cout++;
            } while (start != cur);
        }
    }

    //暴力法
    public void rotate2(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[0];
            int temp2;
            for (int j = 1; j < nums.length; j++) {
                temp2 = nums[j];

                nums[j] = temp;
                temp = temp2;
            }
            nums[0] = temp;
        }
    }

    //复习 暴力法
    public static void rotate3(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }

        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
    }

    //复习 反转数组法
    public static void rotate4(int[] nums, int k) {
        if (nums == null) {
            return;
        }

        k %= nums.length;
        reverse1(nums, 0, nums.length - 1);
        reverse1(nums, 0, k - 1);
        reverse1(nums, k, nums.length - 1);
    }

    public static void reverse1(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    //复习 环状替代法
    public static void rotate5(int[] nums, int k) {
        k %= nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int i = start;
            int temp1;
            int temp2 = nums[i];
            while (true) {
                int next = (i + k) % nums.length;
                temp1 = nums[next];
                nums[next] = temp2;
                temp2 = temp1;
                count++;
                i = next;
                if (i == start) {
                    break;
                }
            }
        }
    }

}
