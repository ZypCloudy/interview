package CodingInterviewChinese2.java;

/**
 * 面试题15：二进制中1的个数
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
 * 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 */
public class _15_NumberOf1InBinary {
    public static int NumberOf1(int n) {
        int count = 0;
        for (int i = 0; i < 32; ++i) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    /**
     * 惊喜的解法
     * 只需要循环1的个数次
     */
    public static int MagicNumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            int tmp = n - 1;
            n &= tmp;
            ++count;
        }
        return count;
    }

    // ====================测试代码====================
    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * 功能测试
     */
    private static void test1() {
        int count = _15_NumberOf1InBinary.NumberOf1(5);
        MyTest.equal(count, 2);

        count = _15_NumberOf1InBinary.NumberOf1(-65);
        MyTest.equal(count, 31);
    }

    /**
     * 边界测试
     * 1. Integer.MAX_VALUE
     * 2. Integer.MIN_VALUE
     * 3. 0
     * 4. 1
     * 5. -1
     */
    private static void test2() {
        int count = _15_NumberOf1InBinary.NumberOf1(Integer.MAX_VALUE);
        MyTest.equal(count, 31);

        count = _15_NumberOf1InBinary.NumberOf1(Integer.MIN_VALUE);
        MyTest.equal(count, 1);

        count = _15_NumberOf1InBinary.NumberOf1(0);
        MyTest.equal(count, 0);

        count = _15_NumberOf1InBinary.NumberOf1(1);
        MyTest.equal(count, 1);

        count = _15_NumberOf1InBinary.NumberOf1(-1);
        MyTest.equal(count, 32);
    }
}
