package CodingInterviewChinese2.java;

import java.util.Arrays;
import java.util.Random;

/**
 * 面试题39：数组中出现次数超过一半的数字
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
 * 如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
 * 出现了5次，超过数组长度的一半，因此输出2。
 * 解法2：排序后统计
 * 时间复杂度O(nlogn)
 * 空间复杂度O(1)
 * 数组会乱序
 * <p>
 * 可以直接调用Array.sort，但是复习一下快排，这里就直接自己写了
 */
public class _39_MoreThanHalfNumber_02 {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];
        quickSort(array);
        int num = array.length / 2 + 1;
        int number = array[0];
        int count = 0;

        for (int i : array) {
            if (i == number) {
                ++count;
                if (count >= num)
                    return i;
            } else {
                number = array[i];
                count = 1;
            }
        }
        return 0;
    }

    private void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low >= high)
            return;
        int p = partition(array, low, high);
        quickSort(array, low, p - 1);
        quickSort(array, p + 1, high);
    }

    private int partition(int[] array, int low, int high) {
        int val = array[low];
        int i = low + 1;
        int j = high;
        while (true) {
            while (i <= high && array[i] < val)
                ++i;
            while (j >= low && array[j] > val)
                --j;
            if (i > j)
                break;
            swap(array, i++, j--);
        }
        swap(array, low, j);
        return j;
    }

    private void swap(int[] array, int indexA, int indexB) {
        int t = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = t;
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
        _39_MoreThanHalfNumber_02 m = new _39_MoreThanHalfNumber_02();
        int res = m.MoreThanHalfNum_Solution(new int[]{2, 4, 1, 3, 4, 4, 1, 4, 4, 6, 4});
        MyTest.equal(res, 4);

        res = m.MoreThanHalfNum_Solution(new int[]{2, 4, 1, 3, 4, 4, 1, 4, 4, 6});
        MyTest.equal(res, 0);
    }

    /**
     * 边界测试
     * 1.只有一个元素
     */
    private static void test2() {
        _39_MoreThanHalfNumber_02 m = new _39_MoreThanHalfNumber_02();
        int res = m.MoreThanHalfNum_Solution(new int[]{2});
        MyTest.equal(res, 2);
    }

    /**
     * 极端测试
     * 1.输入null
     * 2.输入数组长度为0
     */
    private static void test3() {
        _39_MoreThanHalfNumber_02 m = new _39_MoreThanHalfNumber_02();
        int res = m.MoreThanHalfNum_Solution(null);
        MyTest.equal(res, 0);

        res = m.MoreThanHalfNum_Solution(new int[0]);
        MyTest.equal(res, 0);
    }
}















