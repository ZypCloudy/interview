package CodingInterviewChinese2.java;

/**
 * 面试题20：表示数值的字符串
 * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
 * 字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
 * “1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是
 * <p>
 * 思路：
 * 数字有如下两种情况：
 * A[.B][e|EC]
 * [+|-].B[e|EC]
 * <p>
 * 其中A、C表示数字（带符号或不带符号 ），B表示不带符号的数字
 * []包含的整个部分可有可无，
 * 即：如果是第一种类型 A必须有，[.B]可以有，[e|EC]可以有
 * 如果是第二种类型 [+|-]可以有，.B必须有，[e|EC]可以有
 * <p>
 * <p>
 * 第一次挂：-.123应该输出true
 * 第二次挂：12e应该输出false
 * 第三次挂：+-5应该输出false
 *
 * @author peige
 */
public class _20_NumericStrings {

    private int index;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        index = 0;
        boolean isNumeric = false;
        // 走到 A↓[.B][e|EC]  或者  [+|-]↓.B[e|EC]
        isNumeric = isNumericCore(str);
        // 走到 A[.B]↓[e|EC]  或者  [+|-].B↓[e|EC]
        if (index != str.length && str[index] == '.') {
            ++index;
            isNumeric = isUnsignedNumeric(str);
        }
        // 必须有的A或者.B都没有
        if (isNumeric == false)
            return false;

        if (index != str.length && (str[index] == 'e' || str[index] == 'E')) {
            ++index;
            isNumeric = isNumericCore(str);
        }
        return isNumeric && index == str.length;
    }


    private boolean isUnsignedNumeric(char[] str) {
        boolean hasNumeric = false;
        while (index < str.length) {
            if ('0' <= str[index] && str[index] <= '9') {
                hasNumeric = true;
                ++index;
                continue;
            }
            break;
        }
        return hasNumeric;
    }

    private boolean isNumericCore(char[] str) {
        if (index >= str.length)
            return false;
        if (str[index] == '+' || str[index] == '-')
            ++index;
        return isUnsignedNumeric(str);
    }

    /**
     * 数字有如下两种情况：
     * A[.B][e|EC]
     * .B[e|EC]
     */
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    /**
     * 功能测试
     * +1.23e-6
     * -2.2
     * 2.4
     * 2
     * .4E+9
     * .123
     */
    private static void test1() {
        _20_NumericStrings ns = new _20_NumericStrings();
        boolean b = ns.isNumeric(new char[]{'+', '1', '.', '2', '3', 'e', '-', '6'});
        MyTest.equal(b, true);

        b = ns.isNumeric(new char[]{'-', '2', '.', '2'});
        MyTest.equal(b, true);

        b = ns.isNumeric(new char[]{'2', '.', '4'});
        MyTest.equal(b, true);

        b = ns.isNumeric(new char[]{'2'});
        MyTest.equal(b, true);

        b = ns.isNumeric(new char[]{'.', '4', 'E', '+', '9'});
        MyTest.equal(b, true);

        b = ns.isNumeric(new char[]{'.', '1', '2', '3'});
        MyTest.equal(b, true);
        System.out.println("==================================================");
    }

    /**
     * 功能测试
     * +1.23-6
     * -2.
     * 2+
     * e.123
     */
    private static void test2() {
        _20_NumericStrings ns = new _20_NumericStrings();
        boolean b = ns.isNumeric(new char[]{'+', '1', '.', '2', '3', '-', '6'});
        MyTest.equal(b, false);

        b = ns.isNumeric(new char[]{'-', '2', '.'});
        MyTest.equal(b, false);

        b = ns.isNumeric(new char[]{'2', '+'});
        MyTest.equal(b, false);

        b = ns.isNumeric(new char[]{'e', '.', '1', '2', '3'});
        MyTest.equal(b, false);
        System.out.println("==================================================");
    }

    /**
     * 边界测试
     * 1.只有一个数字
     * 2.只有一个符号
     * 3.e
     * 4.只有一个.
     * 5.字符串长度为0
     */
    private static void test3() {
        _20_NumericStrings ns = new _20_NumericStrings();
        boolean b = ns.isNumeric(new char[]{'1'});
        MyTest.equal(b, true);

        b = ns.isNumeric(new char[]{'-'});
        MyTest.equal(b, false);

        b = ns.isNumeric(new char[]{'e'});
        MyTest.equal(b, false);

        b = ns.isNumeric(new char[]{'.'});
        MyTest.equal(b, false);

        b = ns.isNumeric(new char[0]);
        MyTest.equal(b, false);
        System.out.println("==================================================");
    }

    /**
     * 极端测试
     * null
     */
    private static void test4() {
        _20_NumericStrings ns = new _20_NumericStrings();
        boolean b = ns.isNumeric(null);
        MyTest.equal(b, false);
    }
}












