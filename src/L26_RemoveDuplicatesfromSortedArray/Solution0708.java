package L26_RemoveDuplicatesfromSortedArray;

import java.util.Arrays;

public class Solution0708 {
    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
       // int[] a = {1};
        int re = removeDuplicates(a);
        System.out.println(re);
        System.out.println(Arrays.toString(a));

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 1;                                  //想清楚双指针分别指向的元素是啥？  这里的index要从0或者1开始的逻辑是啥？ 这里刚刚出错，就时因为没想清楚比较的对象到底时谁？
                                                        //扫描时 扫描指针从第二个元素开始，与新列表的 最后一个元素比较，因此新列表的指针可以指向实元素，也可以指向空的 即将存元素的空间

        for (int i = 1; i < nums.length; i++) {
            if (nums[index-1] < nums[i]) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}
