package CodingInterviewChinese2.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题32（二）：分行从上到下打印二叉树
 * 题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层
 * 打印到一行。
 */
public class _32_02_PrintTreesInLines {

    public static class TreeNode {
        public int val = 0;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null)
            return new ArrayList<>();

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        ArrayList<Integer> lineResult = new ArrayList<>();
        int numOfThisLine = 1;
        int numOfNextLine = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            lineResult.add(node.val);
            --numOfThisLine;
            if (node.left != null) {
                queue.add(node.left);
                ++numOfNextLine;
            }
            if (node.right != null) {
                queue.add(node.right);
                ++numOfNextLine;
            }
            if (numOfThisLine == 0) {
                result.add(lineResult);
                lineResult = new ArrayList<>();
                numOfThisLine = numOfNextLine;
                numOfNextLine = 0;
            }
        }
        return result;
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
        System.out.println(_32_02_PrintTreesInLines.Print(root));
    }

    /**
     * 边界测试
     * 1.只有一个节点
     * 2.每个节点都只有左子节点
     * 3.每个节点都只有右子节点
     */
    private static void test2() {
        TreeNode root = new TreeNode(1);

        System.out.println(_32_02_PrintTreesInLines.Print(root));

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        node2.left = node3;

        System.out.println(_32_02_PrintTreesInLines.Print(root));

        root.left = null;
        node2.left = null;
        root.right = node2;
        node2.right = node3;
        System.out.println(_32_02_PrintTreesInLines.Print(root));
    }

    /**
     * 极端测试
     * null
     */
    private static void test3() {
        System.out.println(_32_02_PrintTreesInLines.Print(null));
    }
}












