package CodingInterviewChinese2.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题39：数组中出现次数超过一半的数字
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
 * 如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
 * 出现了5次，超过数组长度的一半，因此输出2。
 * 解法1：使用哈希表
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * 数组不会乱序
 */
public class _39_MoreThanHalfNumber_01 {

    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];
        int num = array.length / 2 + 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                int n = map.get(i) + 1;
                if (n >= num)
                    return i;
                map.put(i, n);
            } else
                map.put(i, 1);
        }
        return 0;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * 功能测试
     * 1.存在
     * 2.不存在
     */
    private static void test1() {
        int res = _39_MoreThanHalfNumber_01.MoreThanHalfNum_Solution(
                new int[]{2, 4, 1, 3, 4, 4, 1, 4, 4, 6, 4});
        MyTest.equal(res, 4);

        res = _39_MoreThanHalfNumber_01.MoreThanHalfNum_Solution(
                new int[]{2, 4, 1, 3, 4, 4, 1, 4, 4, 6});
        MyTest.equal(res, 0);
    }

    /**
     * 边界测试
     * 1.只有一个元素
     */
    private static void test2() {
        int res = _39_MoreThanHalfNumber_01.MoreThanHalfNum_Solution(new int[]{2});
        MyTest.equal(res, 2);
    }

    /**
     * 极端测试
     * 1.输入null
     * 2.输入数组长度为0
     */
    private static void test3() {
        int res = _39_MoreThanHalfNumber_01.MoreThanHalfNum_Solution(null);
        MyTest.equal(res, 0);

        res = _39_MoreThanHalfNumber_01.MoreThanHalfNum_Solution(new int[0]);
        MyTest.equal(res, 0);
    }
}









