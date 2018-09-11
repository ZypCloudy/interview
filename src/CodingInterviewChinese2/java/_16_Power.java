package CodingInterviewChinese2.java;

/**
 * 面试题16：数值的整数次方
 * 题目：实现函数double Power(double base, int exponent)，求base的exponent
 * 次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * 思路：
 * public double Power(double base, int exp)
 * 即 base ^ exp
 * 如果exp为偶数，则拆分成(base ^ (exp/2)) * (base ^ (exp/2))
 * 如果exp为奇数，则拆分成(base ^ (exp/2)) * (base ^ (exp/2)) * base
 * <p>
 * 注意：exp可能为负数，负数时先将 exp 转换成绝对值，求出答案 res，最终答案为 1/res
 */
public class _16_Power {

    public double Power(double base, int exponent) {
        if (base == 0)
            return 0;
        if (exponent == 0)
            return 1;
        boolean positive = exponent > 0;
        exponent = positive ? exponent : -exponent;

        if (positive)
            return PowerCore(base, exponent);
        else
            return 1 / PowerCore(base, exponent);
    }

    private double PowerCore(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        double tmp = Power(base, exponent / 2);
//        double tmp = Power(base, exponent >> 1);

        if (exponent % 2 == 0)
//        if ((exponent & 1) == 0)
            return tmp * tmp;
        else
            return tmp * tmp * base;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * 功能测试
     * 1.正数次方
     * 2.负数次方
     */
    private static void test1() {
        _16_Power power = new _16_Power();
        double res = power.Power(1.1, 2);
        MyTest.equal(res, 1.21);

        res = power.Power(3, 3);
        MyTest.equal(res, 27);

        res = power.Power(-2, 3);
        MyTest.equal(res, -8);

        res = power.Power(5, -2);
        MyTest.equal(res, 0.04);

        res = power.Power(-2, -3);
        MyTest.equal(res, -0.125);
    }

    /**
     * 边界测试
     * 1.base为0
     * 2.exponent为0
     */
    private static void test2() {
        _16_Power power = new _16_Power();
        double res = power.Power(0, 5);
        MyTest.equal(res, 0);

        res = power.Power(3, 0);
        MyTest.equal(res, 1);
    }
}


















