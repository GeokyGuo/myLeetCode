package 复习一轮;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class Knowlege_Deque {


/**
 *  结论：
 *  deque是 左边是头，右边是尾，可以直接构造 成  从左到右的列表
 *  deque直接用做stack  用push pop peek 方法   ，每次的push 是offerFirst，即新元素都在最左边  peek也是最左边
 *  deque直接用做queue  用offer poll peek  方法， 每次offer 是offerLast，即新元素在最右边，poll是pollFirst，即删除的是最左边， peek的也是最左边的头
 *  Stack类的 stack， 每次push，新元素都在最右边  peek也是最后边
 **/

//deque 中不能存放null，会报空指针
//基本类型不能null相比较，也会报空指针


    public static void main(String[] args) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(null);
//        System.out.println(queue.size());

        Deque<Integer> stack = new ArrayDeque<>();

        stack.peekLast();
        stack.offer(1);
        stack.offer(2);
        stack.offer(3);
        stack.offerLast(4);
        stack.offerFirst(0);
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            System.out.println(stack.pollFirst());
        }
        System.out.println("============");
        stack = new ArrayDeque<>();
        stack.offer(1);
        stack.offer(2);
        stack.offer(3);
        stack.poll();
        len = stack.size();
        for (int i = 0; i < len; i++) {
            System.out.println(stack.pollFirst());
        }
        System.out.println("============");
        stack = new ArrayDeque<>();
        stack.offer(1);
        stack.offer(2);
        stack.offer(3);
        ArrayList list = new ArrayList(stack);
        len = list.size();
        for (int i = 0; i < len; i++) {
            System.out.println(list.get(i));
        }

        System.out.println("============");
        stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        len = stack.size();
        for (int i = 0; i < len; i++) {
            System.out.println(stack.pollFirst());
        }

        System.out.println("============");
        stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        len = stack.size();
        for (int i = 0; i < len; i++) {
            System.out.println(stack.pollFirst());
        }

        System.out.println("============");
        stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        list = new ArrayList(stack);

        len = list.size();
        for (int i = 0; i < len; i++) {
            System.out.println(list.get(i));
        }

        System.out.println("============");
        Stack stack1 = new Stack();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        list = new ArrayList(stack1);

        System.out.println(stack.peek());

        len = list.size();
        for (int i = 0; i < len; i++) {
            System.out.println(list.get(i));
        }
    }


}
