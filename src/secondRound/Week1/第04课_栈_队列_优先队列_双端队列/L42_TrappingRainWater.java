package secondRound.Week1.第04课_栈_队列_优先队列_双端队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class L42_TrappingRainWater {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int re = trap(nums);
        System.out.println(re);

    }


    //当高度 比当前小 不用管， 证明可以存水
    //当高度比当前大，或者和当前一样，证明要开始退栈 进行计算了
    public static int trap(int[] height) {
        Deque<Integer> deque = new ArrayDeque<>();
        int arc = 0;
        for (int i = 0; i < height.length; i++) {
//            System.out.println(deque.peekFirst() != null );
//            System.out.println(height[i] );
//            System.out.println(deque.peekLast());
            while (deque.peekFirst() != null && height[i] > height[deque.peekLast()]) {
                int curId = deque.pollLast();
                if (deque.peekLast() == null) {
                    break;
                }
                int broad = i - deque.peekLast() - 1;
                int highth = Math.min(height[i], height[deque.peekLast()]) - height[curId];
                if (highth > 0) {
                    arc += broad * highth;
                }
            }
            deque.offerLast(i);
        }
        return arc;
    }
}
