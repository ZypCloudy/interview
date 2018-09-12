package CodingInterviewChinese2.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题32（一）：不分行从上往下打印二叉树
 * 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 */
public class _32_01_PrintTreeFromTopToBottom {

    public static class TreeNode {
        public int val = 0;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return list;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * 功能测试
     *     1
     *    / \
     *   2   3
     *  / \   \
     * 4   5   6
     */
    private static void test1() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        System.out.println(_32_01_PrintTreeFromTopToBottom.PrintFromTopToBottom(root));
    }

    /**
     * 边界测试
     * 1.只有一个节点
     * 2.每个节点都只有左子节点
     * 3.每个节点都只有右子节点
     */
    private static void test2() {
        TreeNode root = new TreeNode(1);

        System.out.println(_32_01_PrintTreeFromTopToBottom.PrintFromTopToBottom(root));

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        node2.left = node3;

        System.out.println(_32_01_PrintTreeFromTopToBottom.PrintFromTopToBottom(root));

        root.left = null;
        node2.left = null;
        root.right = node2;
        node2.right = node3;
        System.out.println(_32_01_PrintTreeFromTopToBottom.PrintFromTopToBottom(root));
    }

    /**
     * 极端测试
     * null
     */
    private static void test3() {
        System.out.println(_32_01_PrintTreeFromTopToBottom.PrintFromTopToBottom(null));
    }
}

















