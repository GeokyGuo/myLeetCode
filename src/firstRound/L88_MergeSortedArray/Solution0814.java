package firstRound.L88_MergeSortedArray;

import java.util.Arrays;

public class Solution0814 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 6, 9, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {2, 9, 13, 15};
        merge(nums1, 4, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[i] = nums1[m];
                m--;
                i--;
            } else {
                nums1[i] = nums2[n];
                n--;
                i--;
            }
        }
        while (m >= 0) {
            nums1[i] = nums1[m];
            m--;
            i--;
        }
        while (n >= 0) {
            nums1[i] = nums2[n];
            n--;
            i--;
        }
    }
}
