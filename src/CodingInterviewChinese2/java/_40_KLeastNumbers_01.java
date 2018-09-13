package CodingInterviewChinese2.java;

import java.util.ArrayList;

/**
 * 面试题40：最小的k个数
 * 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
 * 这8个数字，则最小的4个数字是1、2、3、4。
 * ps：题目只要求最小的k个数，没有要求这k个数要排序
 * <p>
 * 解法1：
 * 使用partition算法
 * 时间复杂度为O(n)
 * 空间复杂度为O(1)
 * 数组会乱序
 */
public class _40_KLeastNumbers_01 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || k <= 0 || k > input.length)
            return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        int end = input.length - 1;
        int p = partition(input, start, end);
        while (p != k - 1) {
            if (p > k - 1)
                end = p - 1;
            if (p < k - 1)
                start = p + 1;
            p = partition(input, start, end);
        }
        for (int i = 0; i < k; ++i)
            result.add(input[i]);
        return result;
    }

    private int partition(int[] array, int low, int high) {
        if (low >= high) return low;
        int val = array[0];
        int i = low;
        int j = high + 1;
        while (true) {
            while (array[++i] < val) if (i == high) break;
            while (array[--j] > val) if (j == low) break;
            if (i >= j) break;
            swap(array, i, j);
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
     */
    private static void test1() {
        _40_KLeastNumbers_01 kn = new _40_KLeastNumbers_01();
        // 1 2 3 4
        System.out.println(kn.GetLeastNumbers_Solution(new int[]{6, 4, 2, 1, 3, 5}, 4));
        // 1 2 3
        System.out.println(kn.GetLeastNumbers_Solution(new int[]{5, 3, 2, 1, 4, 6}, 3));
    }

    /**
     * 边界测试
     * 1.只有一个元素
     * 2.有多个元素，并且全输出
     */
    private static void test2() {
        _40_KLeastNumbers_01 kn = new _40_KLeastNumbers_01();
        // 6
        System.out.println(kn.GetLeastNumbers_Solution(new int[]{6}, 1));
        // 1 2 3 4 5 6
        System.out.println(kn.GetLeastNumbers_Solution(new int[]{5, 3, 2, 1, 4, 6}, 6));
    }

    /**
     * 极端测试
     * 1.数组为null
     * 2.数组长度为0
     * 3.k <= 0
     * 4.k超过数组长度
     */
    private static void test3() {
        _40_KLeastNumbers_01 kn = new _40_KLeastNumbers_01();
        // []
        System.out.println(kn.GetLeastNumbers_Solution(null, 1));
        // []
        System.out.println(kn.GetLeastNumbers_Solution(new int[0], 2));
        // []
        System.out.println(kn.GetLeastNumbers_Solution(new int[]{1, 2, 3}, 0));
        // []
        System.out.println(kn.GetLeastNumbers_Solution(new int[]{1, 2, 3}, -1));
        // []
        System.out.println(kn.GetLeastNumbers_Solution(new int[]{1, 2, 3}, 5));
    }
}










