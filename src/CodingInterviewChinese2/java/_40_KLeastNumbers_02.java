package CodingInterviewChinese2.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 面试题40：最小的k个数
 * 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
 * 这8个数字，则最小的4个数字是1、2、3、4。
 * ps：题目只要求最小的k个数，没有要求这k个数要排序
 * <p>
 * 解法2：
 * 使用优先队列来做（也可以用红黑树来做）
 * 时间复杂度为O(nlogk)
 * 空间复杂度为O(k)
 * 数组不会乱序
 * <p>
 * 这个在eclipse编译没错，提交的时候缺编译不通过，估计是Java版本问题
 */
public class _40_KLeastNumbers_02 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || k <= 0 || k > input.length)
            return new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : input) {
            if (queue.size() != k)
                queue.add(i);
            else if (queue.peek() > i) {
                queue.poll();
                queue.offer(i);
            }
        }
        return new ArrayList<>(queue);
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
        _40_KLeastNumbers_02 kn = new _40_KLeastNumbers_02();
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
        _40_KLeastNumbers_02 kn = new _40_KLeastNumbers_02();
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
        _40_KLeastNumbers_02 kn = new _40_KLeastNumbers_02();
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