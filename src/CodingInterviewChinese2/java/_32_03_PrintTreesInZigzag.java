package CodingInterviewChinese2.java;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 面试题32（三）：之字形打印二叉树
 * 题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺
 * 序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，
 * 其他行以此类推。
 */
public class _32_03_PrintTreesInZigzag {

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
        ArrayList<Integer> lineResult = new ArrayList<>();

        LinkedList<TreeNode> oddLineStack = new LinkedList<>();        // 奇数行
        LinkedList<TreeNode> evenLineStack = new LinkedList<>();    // 偶数行
        boolean isOddLineNow = true;    // 正在遍历的是奇数行还是偶数行
        oddLineStack.addFirst(pRoot);

        while (!oddLineStack.isEmpty() || !evenLineStack.isEmpty()) {
            if (isOddLineNow) {
                while (!oddLineStack.isEmpty()) {
                    TreeNode node = oddLineStack.removeFirst();
                    lineResult.add(node.val);
                    if (node.left != null)
                        evenLineStack.addFirst(node.left);
                    if (node.right != null)
                        evenLineStack.addFirst(node.right);
                }
                isOddLineNow = false;
                result.add(lineResult);
                lineResult = new ArrayList<>();
            } else {
                while (!evenLineStack.isEmpty()) {
                    TreeNode node = evenLineStack.removeFirst();
                    lineResult.add(node.val);
                    if (node.right != null)
                        oddLineStack.addFirst(node.right);
                    if (node.left != null)
                        oddLineStack.addFirst(node.left);
                }
                isOddLineNow = true;
                result.add(lineResult);
                lineResult = new ArrayList<>();
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
        System.out.println(_32_03_PrintTreesInZigzag.Print(root));
    }

    /**
     * 边界测试
     * 1.只有一个节点
     * 2.每个节点都只有左子节点
     * 3.每个节点都只有右子节点
     */
    private static void test2() {
        TreeNode root = new TreeNode(1);

        System.out.println(_32_03_PrintTreesInZigzag.Print(root));

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        node2.left = node3;

        System.out.println(_32_03_PrintTreesInZigzag.Print(root));

        root.left = null;
        node2.left = null;
        root.right = node2;
        node2.right = node3;
        System.out.println(_32_03_PrintTreesInZigzag.Print(root));
    }

    /**
     * 极端测试
     * null
     */
    private static void test3() {
        System.out.println(_32_03_PrintTreesInZigzag.Print(null));
    }
}