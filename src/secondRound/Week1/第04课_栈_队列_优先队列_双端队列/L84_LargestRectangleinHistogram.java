package secondRound.Week1.第04课_栈_队列_优先队列_双端队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class L84_LargestRectangleinHistogram {
    public static void main(String[] args) {


    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int max = 0;
        int[] newHeights = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) newHeights[i + 1] = heights[i];

        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) { //要严格小于
                int temp = stack.pop();
                max = Math.max(max, (i - stack.peek() - 1) * newHeights[temp]);//要 -1
            }
            stack.push(i);
        }
        return max;
    }


    //复习
    public int largestRectangleArea1(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;

        for (int i = 0; i < heights.length; i++) newHeights[i + 1] = heights[i];

        for (int i = 0; i < newHeights.length; i++) {

            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int index = stack.pop();
                max = Math.max(max, (i - stack.peek() - 1) * newHeights[index]);//想清楚  面积是怎么算的
            }
            stack.push(i);


        }


        return max;
    }

    public int largestRectangleArea2(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();

        int[] newheights = new int[heights.length + 2];
        newheights[0] = 0;
        newheights[newheights.length - 1] = 0;
        int max = 0;
        for (int i = 0; i < newheights.length; i++) {
            while (!stack.isEmpty() && newheights[i] < newheights[stack.peekLast()]) {
                int height = newheights[stack.pollLast()];
                int wide = i - stack.peekLast() - 1;
                if (height * wide > max) max = height * wide;
            }
            stack.offerLast(i);

        }
        return max;
    }


}
//其它 单调栈的题目 https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
//单调栈的概念和思想  https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/84-by-ikaruga/
// 最简代码 https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhao-liang-bian-di-yi-ge-xiao-yu-ta-de-zhi-by-powc/
// 单调栈，  单调增 用来 找一个元素 右边第一个 小于它的元素， 左边最接近的小于它的元素也被存了 (当元素出栈时，说明这个新元素是出栈元素向后找第一个比其小的元素,当元素出栈后，说明新栈顶元素是出栈元素向前找第一个比其小的元素)


//            单调减  用来  找一个元素 右边第一个大于它的元素，左边最近的大于它的元素也有
