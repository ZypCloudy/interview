package CodingInterviewChinese2.java;

/**
 * 面试题10：斐波那契数列
 * 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
 * 斐波那契数列的定义如下：
 * *         ┌ 0                ,   n = 0
 * * f(n) =  ├ 1                ,   n = 1
 * *         └ f(n-1) + f(n-2)  ,   n > 1
 * *
 * * 0,1,1,2,3,5,8,13...
 */
public class _10_Fibonacci {
    public static int Fibonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;

        int min = 0;
        int max = 1;
        int fib = 1;
        for (int i = 2; i <= n; ++i) {
            fib = max + min;
            min = max;
            max = fib;
        }
        return fib;
    }

    // ====================测试代码====================
    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * 功能测试 && 边界值测试
     */
    private static void test1() {
        for (int i = 0; i < 10; ++i) {
            System.out.print(_10_Fibonacci.Fibonacci(i) + " ");
        }
        System.out.println();
    }

    /**
     * 性能测试
     */
    private static void test2() {
        System.out.println(_10_Fibonacci.Fibonacci(20));
        System.out.println(_10_Fibonacci.Fibonacci(46)); // 最大n=46，1836311903
    }
}