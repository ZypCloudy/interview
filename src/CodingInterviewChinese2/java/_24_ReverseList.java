package CodingInterviewChinese2.java;

/**
 * 面试题24：反转链表
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
 * 头结点。
 */
public class _24_ReverseList {

    public static class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        // 长度为0或1
        if (head == null || head.next == null)
            return head;

        ListNode first = head;
        ListNode second = head.next;
        head.next = null;
        ListNode third;
        while (second != null) {
            third = second.next;
            second.next = first;
            first = second;
            second = third;
        }
        return first;
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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // 4-3-2-1
        node1 = _24_ReverseList.ReverseList(node1);
        printList(node1);
    }

    /**
     * 边界测试
     * 长度为1
     */
    private static void test2() {
        ListNode node1 = new ListNode(5);
        node1 = _24_ReverseList.ReverseList(node1);
        printList(node1);
    }

    /**
     * 极端测试
     */
    private static void test3() {
        ListNode node1 = _24_ReverseList.ReverseList(null);
        printList(node1);
    }

    private static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}















