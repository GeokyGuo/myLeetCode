package secondRound.Week8.第18课_排序算法.无场景排序.选择;

import java.util.Arrays;

public class 堆排序 {
    //len 是下标，最大长度的下标编号 从0
    public static void main(String[] args) {
        int[] num = {5, 97, 9, 8, 4, 1, 6, 7};
        heapSort(num);
        System.out.println(Arrays.toString(num));
    }

    public static void heapSort(int[] nums) {
        buildHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            adjustDown(nums, 0, i - 1);
        }
    }

    private static void adjustDown(int[] nums, int i, int len) {
        int largest = i;
        int left = largest * 2 + 1;
        int right = largest * 2 + 2;

        if (left <= len && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right <= len && nums[right] > nums[largest]) {
            largest = right;
        }

        if (i != largest) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            adjustDown(nums, largest, len);
        }
    }

    private static void buildHeap(int[] nums) {
        int start = (nums.length - 1 - 1) / 2;
        for (int i = start; i >= 0; i--) {
            adjustDown(nums, i, nums.length - 1);
        }
    }


//    一下是伪代码，
//    public void deleteRoot(int[] nums, int k) {
//        int last = nums.length - 1;
//        int temp = nums[last];
//        nums[last] = nums[k];
//        nums[k] = temp;
//        adjustDown(nums, k, last - 1);
//    }
//
//    public void add(int[] nums, int key) {
//        int curIndex = nums.length;
//        int parentIndex = (curIndex- 1) / 2;
//        while (parentIndex>= 0 && nums[parentIndex] < key) {
//            nums[curIndex] = nums[parentIndex];
//            curIndex =parentIndex;
//            parentIndex = (parentIndex-1)/2;
//        }
//        nums[curIndex] = key;
//
//    }
}
