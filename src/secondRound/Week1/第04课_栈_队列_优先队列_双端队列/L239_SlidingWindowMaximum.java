package secondRound.Week1.第04课_栈_队列_优先队列_双端队列;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class L239_SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] nums = {1, -1};
        int k = 3;
        int[] re = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(re));

    }

    //前K个, 找到最大值，进对尾
    //前进一位，  如果窗口的最后恰好等于的  单调栈的头，则先弹出头， 如果比队尾不为空，且比队尾大，就一直弹出队尾，得到最大值

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<Integer>();
        int[] re = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {

            while (deque.peekLast() != null && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);

            if (i >= k && nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }

            if (i >= k - 1) {
                re[i - k + 1] = deque.peekFirst();
            }
        }


        return re;
    }
}
