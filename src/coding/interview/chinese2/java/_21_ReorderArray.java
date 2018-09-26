package coding.interview.chinese2.java;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 面试题21：调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
 * 奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * <p>
 * 思路：
 * 感觉这道题并没有比较完美的解法，要么时间复杂度高，要么空间复杂度高
 * 解法1：
 * 遍历数组，将所有奇数前移，将所有偶数保存在队列里，并统计奇数个数
 * 将队列里的偶数再放到数组中
 * 时间复杂度O(n)，空间复杂度O(n)
 * 解法2：
 * 用i表示第一个偶数的下标，j表示i后面第一个奇数的下标（i，j初始化都为-1）
 * 当找到符合的i,j时，将下标为[i,j)的值向后移一位（这个范围内都是偶数），
 * 将原本下标为i的偶数替换为原本下标为j的奇数
 * 最坏时间复杂度为O(n)，空间复杂度为O(1)
 */
public class _21_ReorderArray {

    /**
     * 使用解法1
     */
    public static void reOrderArray(int[] array) {
        if (array == null || array.length == 0)
            return;
        LinkedList<Integer> list = new LinkedList<>();
        int index = 0;
        for (int val : array) {
            // 奇数
            if ((val & 1) == 1) {
                array[index++] = val;
            } else {
                list.add(val);
            }
        }
        while (index != array.length) {
            array[index++] = list.removeFirst();
        }
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
        int[] array1 = {1, 2, 3, 4, 5};
        _21_ReorderArray.reOrderArray(array1);
        printArray(array1);

        int[] array2 = {1, 2, 1, 4, 5, 6, 3};
        _21_ReorderArray.reOrderArray(array2);
        printArray(array2);
    }

    /**
     * 边界测试
     * 1.全是偶数
     * 2.全是奇数
     * 3.只有一个元素
     */
    private static void test2() {
        int[] array1 = {2, 2, 2, 2};
        _21_ReorderArray.reOrderArray(array1);
        printArray(array1);

        int[] array2 = {3, 3, 3, 3, 3};
        _21_ReorderArray.reOrderArray(array2);
        printArray(array2);

        int[] array3 = {1};
        _21_ReorderArray.reOrderArray(array3);
        printArray(array3);
    }

    /**
     * 极端测试
     */
    private static void test3() {
        int[] array1 = null;
        _21_ReorderArray.reOrderArray(array1);
        printArray(array1);

        int[] array2 = new int[0];
        _21_ReorderArray.reOrderArray(array2);
        printArray(array2);
    }

    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}














