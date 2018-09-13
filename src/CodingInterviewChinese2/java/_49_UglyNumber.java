package CodingInterviewChinese2.java;

/**
 * 面试题49：丑数
 * 题目：我们把只包含因子2、3和5的数称作丑数（Ugly Number）。求按从小到
 * 大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做第一个丑数。
 */
public class _49_UglyNumber {

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        int uglyNumbers[] = new int[index];
        uglyNumbers[0] = 1;
        int count = 1;
        int indexOf2 = 0;
        int indexOf3 = 0;
        int indexOf5 = 0;
        int numOf2, numOf3, numOf5;

        while (count < index) {
            numOf2 = uglyNumbers[indexOf2] * 2;
            numOf3 = uglyNumbers[indexOf3] * 3;
            numOf5 = uglyNumbers[indexOf5] * 5;
            int min = min(numOf2, numOf3, numOf5);
            if (min == numOf2)
                indexOf2++;
            if (min == numOf3)
                indexOf3++;
            if (min == numOf5)
                indexOf5++;
            uglyNumbers[count++] = min;
        }
        return uglyNumbers[index - 1];
    }

    private int min(int a, int b, int c) {
        return a < b ? (a < c ? a : c)
                : (b < c ? b : c);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        _49_UglyNumber un = new _49_UglyNumber();
        MyTest.equal(4, un.GetUglyNumber_Solution(4));
        MyTest.equal(10, un.GetUglyNumber_Solution(9));
    }

    private static void test2() {
        _49_UglyNumber un = new _49_UglyNumber();
        MyTest.equal(1, un.GetUglyNumber_Solution(1));
    }


    private static void test3() {
        _49_UglyNumber un = new _49_UglyNumber();
        MyTest.equal(0, un.GetUglyNumber_Solution(-1));
        MyTest.equal(0, un.GetUglyNumber_Solution(0));
    }
}