package coding.interview.chinese2.java;

/**
 * 面试题18（二）：删除链表中重复的结点
 * 题目：在一个排序的链表中，如何删除重复的结点？例如，在图3.4（a）中重复
 * 结点被删除之后，链表如图3.4（b）所示。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class _18_02_DeleteDuplicatedNode {

    public static class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;

        ListNode newHead = new ListNode(0);
        ListNode node = newHead;
        boolean flag = true;

        ListNode tmpNode = pHead;
        ListNode current = pHead;

        while ((current = current.next) != null) {
            if (current.val == tmpNode.val) {
                flag = false;
            }
            // 之前没有重复元素
            else if (flag == true) {
                node.next = tmpNode;
                node = node.next;
                tmpNode = current;
            }
            // 之前有重复元素
            else {
                tmpNode = current;
                flag = true;
            }
        }
        if (flag == true)
            node.next = tmpNode;
        else
            node.next = null;
        return newHead.next;
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
        // 1-2-5
        ListNode head1 = createListNode(1, 2, 3, 3, 4, 4, 5);
        head1 = _18_02_DeleteDuplicatedNode.deleteDuplication(head1);
        printListNode(head1);

        // 7
        ListNode head2 = createListNode(6, 6, 6, 6, 6, 7);
        head2 = _18_02_DeleteDuplicatedNode.deleteDuplication(head2);
        printListNode(head2);
    }

    /**
     * 边界测试
     * 1.全是重复元素
     * 2.没有重复元素
     * 3.只有一个元素
     */
    private static void test2() {
        // null
        ListNode head1 = createListNode(6, 6, 6, 6, 7, 7, 7, 8, 8);
        head1 = _18_02_DeleteDuplicatedNode.deleteDuplication(head1);
        printListNode(head1);

        // 1-2-3-4-5
        ListNode head2 = createListNode(1, 2, 3, 4, 5);
        head2 = _18_02_DeleteDuplicatedNode.deleteDuplication(head2);
        printListNode(head2);

        // 1
        ListNode head3 = createListNode(1);
        head3 = _18_02_DeleteDuplicatedNode.deleteDuplication(head3);
        printListNode(head3);
    }

    /**
     * 极端测试
     * 1.头结点为null
     */
    private static void test3() {
        // null
        ListNode head1 = _18_02_DeleteDuplicatedNode.deleteDuplication(null);
        printListNode(head1);
    }

    private static void printListNode(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    private static ListNode createListNode(int... values) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int val : values) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return head.next;
    }
}














