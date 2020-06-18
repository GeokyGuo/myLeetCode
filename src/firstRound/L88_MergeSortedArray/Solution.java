package firstRound.L88_MergeSortedArray;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 6, 9, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {2, 9, 13, 15};
        merge(nums1, 4, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] re = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                re[k++] = nums1[i++];
            } else {
                re[k++] = nums2[j++];
            }
        }
        while (i < m) {
            re[k++] = nums1[i++];
        }
        while (j < n) {
            re[k++] = nums2[j++];
        }

        k = 0;
        while (k < re.length - 1) {
            //nums1[k++] = re[k++];
            nums1[k] = re[k];
            k++;
        }

    }
}
