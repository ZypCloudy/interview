package coding.interview.chinese2.java;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 面试题40：最小的k个数
 * 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
 * 这8个数字，则最小的4个数字是1、2、3、4。
 * ps：题目只要求最小的k个数，没有要求这k个数要排序
 * <p>
 * 解法3：
 * 用红黑树来做
 * 时间复杂度为O(nlogk)
 * 空间复杂度为O(k)
 * 数组不会乱序
 */
public class _40_KLeastNumbers_03 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || k <= 0 || k > input.length)
            return new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : input) {
            if (set.size() != k)
                set.add(i);
            else if (set.last() > i) {
                set.pollLast();
                set.add(i);
            }
        }
        return new ArrayList<>(set);
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
        _40_KLeastNumbers_03 kn = new _40_KLeastNumbers_03();
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
        _40_KLeastNumbers_03 kn = new _40_KLeastNumbers_03();
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
        _40_KLeastNumbers_03 kn = new _40_KLeastNumbers_03();
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