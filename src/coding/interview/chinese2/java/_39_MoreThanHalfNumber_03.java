package coding.interview.chinese2.java;

/**
 * 面试题39：数组中出现次数超过一半的数字
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
 * 如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
 * 出现了5次，超过数组长度的一半，因此输出2。
 * <p>
 * 解法3：基于Partition函数的时间复杂度为O(n)的算法
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 * 数组会乱序
 * <p>
 * 思路：
 * 如果把这个数组排序，那么排序之后位于数组中间的数字
 * 一定就是那个出现次数超过数组长度一般的数字
 */
public class _39_MoreThanHalfNumber_03 {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int midIndex = array.length / 2;
        int start = 0;
        int end = array.length - 1;
        int p = partition(array, start, end);
        while (p != midIndex) {
            if (p > midIndex)
                end = p - 1;
            else if (p < midIndex)
                start = p + 1;
            p = partition(array, start, end);
        }
        if (checkMoreThanHalf(array, array[p]))
            return array[p];
        return 0;
    }

    private boolean checkMoreThanHalf(int[] array, int val) {
        int count = 0;
        for (int i : array) {
            if (i == val)
                ++count;
        }
        return count > array.length / 2;
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
        _39_MoreThanHalfNumber_03 m = new _39_MoreThanHalfNumber_03();
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
        _39_MoreThanHalfNumber_03 m = new _39_MoreThanHalfNumber_03();
        int res = m.MoreThanHalfNum_Solution(new int[]{2});
        MyTest.equal(res, 2);
    }

    /**
     * 极端测试
     * 1.输入null
     * 2.输入数组长度为0
     */
    private static void test3() {
        _39_MoreThanHalfNumber_03 m = new _39_MoreThanHalfNumber_03();
        int res = m.MoreThanHalfNum_Solution(null);
        MyTest.equal(res, 0);

        res = m.MoreThanHalfNum_Solution(new int[0]);
        MyTest.equal(res, 0);
    }
}