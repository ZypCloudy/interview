package coding.interview.chinese2.java;

/**
 * 面试题18（一）：在O(1)时间删除链表结点
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该
 * 结点。
 * <p>
 * 书上的思路：
 * 设链表如下
 * a->b->c->d->e->f
 * 1.如果要删除的节点在链表中间，如要删除节点d，则把e.value和e.next赋值给d，
 * 相当于直接将d节点变成e节点，删除下一个e节点
 * 2.如果要删除的节点是尾节点，只能遍历
 * 3.如果要删除的节点是头结点，则将head指向head的下一个节点
 */
public class _18_01_DeleteNodeInList {
    public static class ListNode {
        ListNode nextNode;
        int nodeValue;
    }

    public static void deleteNode(ListNode head, ListNode deListNode) {
        // 空链表
        if (head == null || deListNode == null) {
            return;
        }
        //不是尾结点
        if (deListNode.nextNode != null) {
            ListNode node = deListNode.nextNode;
            deListNode.nodeValue = node.nodeValue;
            deListNode.nextNode = node.nextNode;
            node = null;
        }
        //只有一个结点，删除头结点
        else if (head == deListNode) {
            deListNode = null;
            head = null;
        }
        //多个结点，删除尾结点
        else {
            ListNode node = head;
            while (node.nextNode != deListNode) {
                node = node.nextNode;
            }
            node.nextNode = null;
            deListNode = null;
        }
    }

    public static void main(String[] args) {
        _18_01_DeleteNodeInList test = new _18_01_DeleteNodeInList();
        ListNode firListNode = new ListNode();
        ListNode secListNode = new ListNode();
        ListNode thiListNode = new ListNode();
        firListNode.nextNode = secListNode;
        secListNode.nextNode = thiListNode;
        firListNode.nodeValue = 1;
        secListNode.nodeValue = 2;
        thiListNode.nodeValue = 3;
        //删除头结点
//        test.deleteNode(firListNode, firListNode);
//        System.out.println(firListNode.nodeValue);

//        //删除中间结点
//        test.deleteNode(firListNode, secListNode);
//        System.out.println(firListNode.nextNode.nodeValue);

        //删除尾结点
        test.deleteNode(firListNode, thiListNode);
        System.out.println(firListNode.nextNode.nodeValue);
    }
}











