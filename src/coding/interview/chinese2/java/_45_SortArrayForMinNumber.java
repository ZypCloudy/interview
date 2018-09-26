package coding.interview.chinese2.java;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 面试题45：把数组排成最小的数
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼
 * 接出的所有数字中最小的一个。例如输入数组{3, 32, 321}，则打印出这3个数
 * 字能排成的最小数字321323。
 * <p>
 * 思路：
 * 考虑到两个数字的拼接可能会出现溢出问题，所以该问题使用字符串来处理
 * 可以转换成字符串排序问题
 * 如数字a与数字b，拼接成字符串ab和字符串ba，
 * 然后按照字典序进行比较，如果ab < ba，则数字a应该排在前面，否则反之
 */
public class _45_SortArrayForMinNumber {

    public static String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            // 不应该出现0的情况
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1) > 0 ? 1 : -1;
            }
        });

        for (int number : numbers) {
            set.add(String.valueOf(number));
        }

        StringBuilder sb = new StringBuilder();
        for (String s : set) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        String s = _45_SortArrayForMinNumber.PrintMinNumber(new int[]{12, 123, 1});
        MyTest.equal(s, "112123");

        s = _45_SortArrayForMinNumber.PrintMinNumber(new int[]{43, 3, 134});
        MyTest.equal(s, "134343");

        s = _45_SortArrayForMinNumber.PrintMinNumber(new int[]{43, 4});
        MyTest.equal(s, "434");

        s = _45_SortArrayForMinNumber.PrintMinNumber(new int[]{45, 4});
        MyTest.equal(s, "445");
    }

    private static void test2() {
        String s = _45_SortArrayForMinNumber.PrintMinNumber(new int[]{4});
        MyTest.equal(s, "4");

        s = _45_SortArrayForMinNumber.PrintMinNumber(new int[]{1, 111, 1111});
        MyTest.equal(s, "11111111");
    }

    private static void test3() {
        String s = _45_SortArrayForMinNumber.PrintMinNumber(null);
        MyTest.equal(s, "");

        s = _45_SortArrayForMinNumber.PrintMinNumber(new int[0]);
        MyTest.equal(s, "");
    }
}