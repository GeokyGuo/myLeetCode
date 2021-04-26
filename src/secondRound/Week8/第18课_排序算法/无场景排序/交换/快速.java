package secondRound.Week8.第18课_排序算法.无场景排序.交换;

import java.util.Arrays;

public class 快速 {
    public static void main(String[] args) {
        int[] num = {5, 97, 9, 8, 4, 1, 6, 7};
        quickSort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int originLow = low;
        int originHigh = high;

        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) high--;
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;

        quickSort(nums, originLow, low - 1);
        quickSort(nums, low + 1, originHigh);

    }
}
