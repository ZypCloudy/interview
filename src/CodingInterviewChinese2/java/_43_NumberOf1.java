package CodingInterviewChinese2.java;


/**
 * 面试题43：从1到n整数中1出现的次数
 * 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如
 * 输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次。
 * <p>
 * 思路：
 * 讲道理，我觉得这道题书上讲的思路并不怎样，而且书上讲得挺模糊的。
 * 我自己想了个办法，挺好解决这道题的。
 * <p>
 * 解法：
 * 以21305这个数为例子
 * <p>
 * 万位出现1的情况有：10000-19999, 一共10000次
 * 千位出现1的情况有：01000-01999, 11000-11999, 21000-21305, 一共2000+306次
 * 百位出现1的情况有：00100-00199, 01100-01199, 02100-02199, ..., 21100-21199, 一共2200次
 * 十位出现1的情况有：00010-00019, 00110-00110, ..., 21210-21219,（没有21310），一共2130次
 * 个位出现1的情况有：00001, 00011, 00021, ..., 21301, 一共2130+1次
 * <p>
 * 所以可以得到以下公式：
 * 万位出现1的情况有（万位大于1）：(21305 / 100000 + 1) * 10000 = 10000 次
 * 千位出现1的情况有（千位等于1）：(21305 / 10000)      * 1000  + 21305 % 1000 + 1 = 2306 次
 * 百位出现1的情况有（百位大于1）：(21305 / 1000   + 1) * 100   = 2200 次
 * 十位出现1的情况有（百位等于0）：(21305 / 100)        * 10    = 2130 次
 * 个位出现1的情况有（个位大于1）：(21305 / 10     + 1) * 1     = 2131 次
 * <p>
 * 时间复杂度为O(k)
 * k为位数
 */
public class _43_NumberOf1 {

    public static int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0)
            return 0;
        int sum = 0;
        for (int k = 1; n / k > 0; k *= 10) {
            int mod = n / k % 10;
            if (mod > 1) {
                sum = sum + (n / (k * 10) + 1) * k;
            } else if (mod == 1) {
                sum = sum + (n / (k * 10)) * k + (n % k) + 1;
            }
            // mod == 0
            else {
                sum = sum + (n / (k * 10)) * k;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * 功能测试
     */
    private static void test1() {
        int res = _43_NumberOf1.NumberOf1Between1AndN_Solution(21305);
        MyTest.equal(res, 18767);

        res = _43_NumberOf1.NumberOf1Between1AndN_Solution(12);
        MyTest.equal(res, 5);
    }

    /**
     * 边界测试
     * 1.输入1
     */
    private static void test2() {
        int res = _43_NumberOf1.NumberOf1Between1AndN_Solution(1);
        MyTest.equal(res, 1);
    }

    /**
     * 极端测试
     * 1.输入0
     * 2.输入负数
     */
    private static void test3() {
        int res = _43_NumberOf1.NumberOf1Between1AndN_Solution(0);
        MyTest.equal(res, 0);

        res = _43_NumberOf1.NumberOf1Between1AndN_Solution(-2);
        MyTest.equal(res, 0);
    }
}