package L88_MergeSortedArray;

import java.util.Arrays;

public class Solution0724 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 6, 9, 11, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {7, 7, 13, 15};
        merge(nums1, 6, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     *用的是从大到小的排序
     * 中间 如果nums1先结束，其实是不用管的，只有第二个nums2还有元素的话，才需要移动
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;

        while (m >= 1 && n >= 1) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                i--;
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                i--;
                n--;
            }
        }
//        while (m >= 1) {
//            nums1[i] = nums1[m - 1];
//            i--;
//            m--;
//        }
        while (n >= 1) {
            nums1[i] = nums2[n - 1];
            i--;
            n--;
        }


    }
}
