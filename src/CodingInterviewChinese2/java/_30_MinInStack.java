package CodingInterviewChinese2.java;

import java.util.Stack;

/**
 * 面试题30：包含min函数的栈
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min
 * 函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。
 */
public class _30_MinInStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else if (minStack.peek() > node) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        test1();
    }

    /**
     * 1.新压入栈的数字比之前的最小值大
     * 2.新压入栈的数字比之前的最小值小
     * 3.弹出栈的数字不是最小元素
     * 4.弹出栈的数字是最小元素
     */
    private static void test1() {
        _30_MinInStack mis = new _30_MinInStack();
        mis.push(4);
        mis.push(5);
        mis.push(6);
        MyTest.equal(mis.top(), 6);
        MyTest.equal(mis.min(), 4);

        mis.pop();
        mis.pop();
        MyTest.equal(mis.top(), 4);
        MyTest.equal(mis.min(), 4);

        mis.push(2);
        MyTest.equal(mis.top(), 2);
        MyTest.equal(mis.min(), 2);

        mis.pop();
        MyTest.equal(mis.top(), 4);
        MyTest.equal(mis.min(), 4);
    }
}
