package coding.interview.chinese2.java;

/**
 * 面试题25：合并两个排序的链表
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按
 * 照递增排序的。例如输入图3.11中的链表1和链表2，则合并之后的升序链表如链
 * 表3所示。
 * 例如：
 * 链表1：1->3->5->7
 * 链表2：2->4->6->8
 * 合并后：1->2->3->4->5->6->7->8
 */
public class _25_MergeSortedLists {

    public static class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }
        }

        if (list1 != null)
            cur.next = list1;
        else if (list2 != null)
            cur.next = list2;

        return head.next;
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
        // 1-2-3-3-4-6-7-8
        ListNode list1 = createList(1, 3, 4, 8);
        ListNode list2 = createList(2, 3, 6, 7);
        ListNode head1 = _25_MergeSortedLists.Merge(list1, list2);
        printList(head1);
    }

    /**
     * 边界测试
     */
    private static void test2() {
        // 4-6
        ListNode list1 = createList(6);
        ListNode list2 = createList(4);
        ListNode head1 = _25_MergeSortedLists.Merge(list1, list2);
        printList(head1);
    }

    /**
     * 极端测试
     * 1.list1为null
     * 2.list2为null
     * 3.list1和list2都为null
     */
    private static void test3() {
        ListNode list1 = createList(1);
        ListNode list2 = createList(2);

        ListNode head1 = _25_MergeSortedLists.Merge(list1, null);
        ListNode head2 = _25_MergeSortedLists.Merge(null, list2);
        ListNode head3 = _25_MergeSortedLists.Merge(null, null);

        printList(head1);
        printList(head2);
        printList(head3);
    }

    private static ListNode createList(int... vals) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int val : vals) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return head.next;
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
