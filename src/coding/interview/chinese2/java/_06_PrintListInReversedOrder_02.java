package coding.interview.chinese2.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 面试题6：从尾到头打印链表
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 *
 * 方法二
 * 思路：使用集合逆序
 *
 * @author zhangyp
 */
public class _06_PrintListInReversedOrder_02 {

    public static class ListNode {
        int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode current = listNode;
        while (current != null) {
            arrayList.add(current.val);
            current = current.next;
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * 功能测试
     * 1.链表有多个节点
     * 2.链表只有一个节点
     */
    private static void test1() {
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(4, 3, 2, 1));
        ArrayList<Integer> arr2 = _06_PrintListInReversedOrder_02.printListFromTailToHead(head1);
        MyTest.equal(arr1.equals(arr2), true);

        ListNode head2 = new ListNode(99);
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(99));
        ArrayList<Integer> arr4 = _06_PrintListInReversedOrder_02.printListFromTailToHead(head2);
        MyTest.equal(arr3.equals(arr4), true);
    }

    /**
     * 特殊输入测试
     * 输入的链表头结点为null
     */
    private static void test2() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arr2 = _06_PrintListInReversedOrder_02.printListFromTailToHead(null);
        MyTest.equal(arrayList.equals(arr2), true);
    }
}
