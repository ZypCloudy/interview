package CodingInterviewChinese2.java;

import java.util.Stack;

// 面试题9：用两个栈实现队列
// 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
// 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。

public class _09_QueueWithTwoStacks {
    Stack<Integer> stack1 = new Stack<>();    // 用来push
    Stack<Integer> stack2 = new Stack<>();    // 用来pop

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.empty())
            throw new RuntimeException("Queue is empty!");

        return stack2.pop();
    }

    // ====================测试代码====================
    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * 往空的队列里添加、删除元素
     */
    private static void test1() {
        _09_QueueWithTwoStacks q = new _09_QueueWithTwoStacks();
        q.push(1);
        q.pop();
    }

    /**
     * 往非空的队列里面添加、删除元素
     */
    private static void test2() {
        _09_QueueWithTwoStacks q = new _09_QueueWithTwoStacks();
        for (int i = 0; i < 5; ++i) {
            q.push(i);
        }
        for (int i = 0; i < 5; ++i) {
            System.out.print(q.pop() + " ");
        }
        System.out.println();
    }
}
