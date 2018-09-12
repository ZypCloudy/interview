package CodingInterviewChinese2.java;

/**
 * 面试题36：二叉搜索树与双向链表
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求
 * 不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class _36_ConvertBinarySearchTree {

    public static class TreeNode {
        public int val = 0;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode lastNodeInList;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;

        lastNodeInList = new TreeNode(0);
        ConvertCore(pRootOfTree);

        TreeNode cur = lastNodeInList;
        while (cur.left != null) {
            cur = cur.left;
        }
        cur = cur.right;
        cur.left = null;
        return cur;
    }

    private void ConvertCore(TreeNode root) {
        if (root.left != null)
            ConvertCore(root.left);

        lastNodeInList.right = root;
        root.left = lastNodeInList;
        lastNodeInList = root;

        if (root.right != null)
            ConvertCore(root.right);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    /**
     * 功能测试
     *     8
     *    / \
     *   4   12
     *  / \  / \
     * 1  6  9  14
     */
    private static void test1() {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(14);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        _36_ConvertBinarySearchTree cbst = new _36_ConvertBinarySearchTree();
        TreeNode root = cbst.Convert(node1);
        printTree(root);
        System.out.println();
    }

    /**
     * 功能测试
     *     1
     *      \
     *       2
     *        \
     *         3
     */
    private static void test2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.right = node3;

        _36_ConvertBinarySearchTree cbst = new _36_ConvertBinarySearchTree();
        TreeNode root = cbst.Convert(node1);
        printTree(root);
        System.out.println();
    }

    /**
     * 功能测试
     *      3
     *     /
     *    2
     *   /
     *  1
     */
    private static void test3() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        node1.left = node2;
        node2.left = node3;

        _36_ConvertBinarySearchTree cbst = new _36_ConvertBinarySearchTree();
        TreeNode root = cbst.Convert(node1);
        printTree(root);
        System.out.println();
    }

    /**
     * 边界测试
     * 只有根节点
     */
    private static void test4() {
        TreeNode node1 = new TreeNode(1);
        _36_ConvertBinarySearchTree cbst = new _36_ConvertBinarySearchTree();
        TreeNode root = cbst.Convert(node1);
        printTree(root);
        System.out.println();
    }

    /**
     * 极端测试
     * 根节点为null
     */
    private static void test5() {
        _36_ConvertBinarySearchTree cbst = new _36_ConvertBinarySearchTree();
        TreeNode root = cbst.Convert(null);
        printTree(root);
        System.out.println();
    }

    private static void printTree(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }
}