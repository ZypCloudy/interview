package CodingInterviewChinese2.java;

/**
 * 面试题22：链表中倒数第k个结点
 * 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
 * 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
 * 值为4的结点。
 */
public class _22_KthNodeFromEnd {

    public static class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;

        ListNode node1 = head;
        ListNode node2 = head;
        for (int i = 0; i < k - 1; ++i) {
            node1 = node1.next;
            if (node1 == null)
                return null;
        }

        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * 功能测试
     * 1-2-3-4-5
     */
    private static void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode n1 = _22_KthNodeFromEnd.FindKthToTail(node1, 1);
        MyTest.equal(n1, node5);
        ListNode n2 = _22_KthNodeFromEnd.FindKthToTail(node1, 3);
        MyTest.equal(n2, node3);
        ListNode n3 = _22_KthNodeFromEnd.FindKthToTail(node1, 5);
        MyTest.equal(n3, node1);
    }

    /**
     * 边界测试
     */
    private static void test2() {
        ListNode node1 = new ListNode(1);
        ListNode n1 = _22_KthNodeFromEnd.FindKthToTail(node1, 1);
        MyTest.equal(n1, node1);
    }

    /**
     * 极端测试
     * 1.链表为null
     * 2.k为0
     * 3.k为负数
     * 4.k大于链表长度
     */
    private static void test3() {
        ListNode n1 = _22_KthNodeFromEnd.FindKthToTail(null, 1);
        System.out.println(n1 == null);

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode n2 = _22_KthNodeFromEnd.FindKthToTail(node1, 0);
        System.out.println(n2 == null);
        ListNode n3 = _22_KthNodeFromEnd.FindKthToTail(node1, -1);
        System.out.println(n3 == null);
        ListNode n4 = _22_KthNodeFromEnd.FindKthToTail(node1, 6);
        System.out.println(n4 == null);
    }
}













