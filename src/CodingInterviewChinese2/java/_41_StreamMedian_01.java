package CodingInterviewChinese2.java;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 面试题41：数据流中的中位数
 * 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么
 * 中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 思路：
 * 用 一个最大堆  + 一个最小堆 来解决
 * 如果能够保持 最大堆里的所有元素 < 最小堆里面的所有元素
 * 如果元素总个数为奇数，最大堆元素个数=最小堆元素个数-1，则最小堆的顶部元素为中位数；
 * 如果元素总个数为偶数，最大堆元素个数=最小堆元素个数，最中位数=（最小堆的顶部元素+最大堆的顶部元素）/2
 * <p>
 * 解法：
 * 1.当插入第偶数个元素时（从第0个开始），将元素插入最大堆后，将最大堆顶部元素放到最小堆里
 * 2.当插入第奇数个元素时，将元素插入最小堆后，将最小堆顶部元素放到最大堆里
 * <p>
 * 所以当插入奇数个元素时，中位数为最小堆顶部元素；
 * 当插入偶数个元素时，中位数为（最大堆顶部元素+最小堆顶部元素）/ 2
 */
public class _41_StreamMedian_01 {

    PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minQ = new PriorityQueue<>();

    public void Insert(Integer num) {
        if (((maxQ.size() + minQ.size()) & 1) == 0) {
            maxQ.offer(num);
            minQ.offer(maxQ.remove());
        } else {
            minQ.offer(num);
            maxQ.offer(minQ.remove());
        }
    }

    public Double GetMedian() {
        if (maxQ.size() == 0 && minQ.size() == 0)
            return new Double(0.0);
        if (((maxQ.size() + minQ.size()) & 1) == 0) {
            return (double) (minQ.peek() + maxQ.peek()) / 2;
        } else {
            return (double) (minQ.peek());
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
        _41_StreamMedian_01 sm = new _41_StreamMedian_01();
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
        _41_StreamMedian_01 sm = new _41_StreamMedian_01();
        System.out.println(sm.GetMedian());
    }
}