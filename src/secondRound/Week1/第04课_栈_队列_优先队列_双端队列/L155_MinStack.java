package secondRound.Week1.第04课_栈_队列_优先队列_双端队列;

import java.util.Stack;



//RunnableException 异常不用被 捕获或者  显式的被抛出
//IOexception 一定要被处理
class MinStack {

    Stack<Integer> data;
    Stack<Integer> helper;


    public MinStack() {
        data = new Stack<Integer>();
        helper = new Stack<Integer>();

    }

    public void push(int x) {
        data.push(x);
        if (helper.empty() || helper.peek() >= x) {
            helper.push(x);
        } else {
            helper.push(helper.peek());
        }
    }

    public void pop() {
        if (!data.empty()) {
            data.pop();
            helper.pop();
        }
    }

    public int top() {
        if (!data.empty()) {
            int re = data.peek();
            return re;
        } else {
            throw new RuntimeException();
        }
    }

    public int getMin() {
        if (!data.empty()) {
            int re = helper.peek();
            return re;
        } else {
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
    }

}

public class L155_MinStack {
    public static void main(String[] args) {


    }

}