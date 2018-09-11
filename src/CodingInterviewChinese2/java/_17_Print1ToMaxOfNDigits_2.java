package CodingInterviewChinese2.java;

/**
 * 面试题17：打印1到最大的n位数
 * 使用递增的方法解决
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
 * 打印出1、2、3一直到最大的3位数即999。
 */
public class _17_Print1ToMaxOfNDigits_2 {

    public static void Print1ToMaxOfNDigits_2(int n) {
        if (n <= 0)
            return;
        char[] digits = new char[n];
        for (int i = 0; i < digits.length; ++i) {
            digits[i] = '0';
        }
        while (Increment(digits)) {
            PrintDigit(digits);
        }
    }

    /**
     * 递增
     */
    private static boolean Increment(char[] digits) {
        digits[0] += 1;
        for (int i = 0; i < digits.length; ++i) {
            int num = digits[i] - '0';
            if (num == 10) {
                if (i == digits.length - 1) {
                    return false;
                }
                digits[i + 1] += 1;
                digits[i] = '0';
            } else {
                break;
            }
        }
        return true;
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
        System.out.print(' ');
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        _17_Print1ToMaxOfNDigits_2.Print1ToMaxOfNDigits_2(1);
        System.out.println();
        _17_Print1ToMaxOfNDigits_2.Print1ToMaxOfNDigits_2(2);
        System.out.println();
        _17_Print1ToMaxOfNDigits_2.Print1ToMaxOfNDigits_2(3);
        System.out.println();
        System.out.println();
    }

    private static void test2() {
        _17_Print1ToMaxOfNDigits_2.Print1ToMaxOfNDigits_2(0);
        System.out.println();
        _17_Print1ToMaxOfNDigits_2.Print1ToMaxOfNDigits_2(-1);
        System.out.println();
    }
}











