package CodingInterviewChinese2.java;

/**
 * 面试题17：打印1到最大的n位数
 * 使用递归的方式解决
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
 * 打印出1、2、3一直到最大的3位数即999。
 */
public class _17_Print1ToMaxOfNDigits_1 {

    public static void Print1ToMaxOfNDigits_1(int n) {
        if (n <= 0)
            return;
        char[] digits = new char[n];
        Print1ToMaxOfNDigits_1(digits, n - 1);
    }

    /**
     * 递归，实现全排列
     */
    private static void Print1ToMaxOfNDigits_1(char[] digits, int index) {
        if (index == -1) {
            PrintDigit(digits);
            return;
        }
        for (int i = 0; i < 10; ++i) {
            digits[index] = (char) ('0' + i);
            Print1ToMaxOfNDigits_1(digits, index - 1);
        }
    }

    /**
     * 打印digits，注意开头不要打印0
     */
    private static void PrintDigit(char[] digits) {
        boolean zeroFlag = true;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] == '0' && zeroFlag)
                continue;
            System.out.print(digits[i]);
            zeroFlag = false;
        }
        if (zeroFlag == false) {
            System.out.print(' ');
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        _17_Print1ToMaxOfNDigits_1.Print1ToMaxOfNDigits_1(1);
        System.out.println();
        _17_Print1ToMaxOfNDigits_1.Print1ToMaxOfNDigits_1(2);
        System.out.println();
        _17_Print1ToMaxOfNDigits_1.Print1ToMaxOfNDigits_1(3);
        System.out.println();
        System.out.println();
    }

    private static void test2() {
        _17_Print1ToMaxOfNDigits_1.Print1ToMaxOfNDigits_1(0);
        System.out.println();
        _17_Print1ToMaxOfNDigits_1.Print1ToMaxOfNDigits_1(-1);
        System.out.println();
    }
}
