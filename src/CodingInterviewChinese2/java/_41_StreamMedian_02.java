package CodingInterviewChinese2.java;

import java.util.Collections;
import java.util.TreeSet;

/**
 * 面试题41：数据流中的中位数
 * 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么
 * 中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 优先队列
 */
public class _41_StreamMedian_02 {

    TreeSet<Integer> maxQ = new TreeSet<>(Collections.reverseOrder());
    TreeSet<Integer> minQ = new TreeSet<>();

    public void Insert(Integer num) {
        if (((maxQ.size() + minQ.size()) & 1) == 0) {
            maxQ.add(num);
            minQ.add(maxQ.pollFirst());
        } else {
            minQ.add(num);
            maxQ.add(minQ.pollFirst());
        }
    }

    public Double GetMedian() {
        if (maxQ.size() == 0 && minQ.size() == 0)
            return new Double(0.0);
        if (((maxQ.size() + minQ.size()) & 1) == 0) {
            return (double) (minQ.first() + maxQ.first()) / 2;
        } else {
            return (double) (minQ.first());
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * 功能测试
     */
    private static void test1() {
        _41_StreamMedian_02 sm = new _41_StreamMedian_02();
        for (int i = 0; i < 10; ++i) {
            sm.Insert(i);
            System.out.print(sm.GetMedian() + "  ");
        }
        System.out.println();
    }

    /**
     * 极端测试
     * 1.没有元素，要获得中位数
     */
    private static void test2() {
        _41_StreamMedian_02 sm = new _41_StreamMedian_02();
        System.out.println(sm.GetMedian());
    }
}