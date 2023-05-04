package 复习一轮;

import java.util.ArrayDeque;
import java.util.Deque;

public class test04 {
    public static void main(String[] args) {
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(maxSlidingWindow(a, k));

    }

    //20
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (Character c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;//todo
        }

        return stack.isEmpty();
    }

    //42
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int temp = stack.pop();//todo
                if (stack.peek() == null) break;
                sum = sum + (Math.min(height[i], height[stack.peek()]) - height[temp]) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return sum;
    }

    //84
    public int largestRectangleArea(int[] heights) {
        int[] newHeight = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) newHeight[i + 1] = heights[i];
        Deque<Integer> stack = new ArrayDeque<>();
        int arc = 0;
        for (int i = 0; i < newHeight.length; i++) {
            while (!stack.isEmpty() && newHeight[i] < newHeight[stack.peek()]) {
                int temp = newHeight[stack.pop()];
                arc = Math.max(arc, (i - stack.peek() - 1) * temp);
            }
            stack.push(i);
        }
        return arc;
    }

    //239
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();

        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (queue.peekFirst() == (i - k)) {
                queue.pollFirst();
            }
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

}
