package CodingInterviewChinese2.java;

// 面试题7：重建二叉树
// 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
// 入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,
// 2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，则重建出
// 图2.6所示的二叉树并输出它的头结点。
public class _07_ConstructBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param pre 前序遍历
     * @param in  中序遍历
     * @return 该二叉树
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0)
            return null;
        TreeNode root = new TreeNode(0);
        buildTree(root, root, pre, 0, pre.length, in, 0, in.length, LEFT);
        if (root == null)
            return null;
        root = root.left;
        return root;
    }

    public static void buildTree(TreeNode root, TreeNode sonRoot, int[] pre, int preStart, int preEnd,
                                 int[] in, int inStart, int inEnd, int leftOrRight) {

        if (sonRoot == null || preStart >= preEnd || inStart >= inEnd)
            return;
        TreeNode newRoot = null;
        int value = pre[preStart];    // 根节点的值
        int leftLen = 0;            // 左子树节点个数
        int i;
        for (i = inStart; i < inEnd; ++i) {
            if (in[i] == value) {
                leftLen = i - inStart;
                break;
            }
        }
        // 前序遍历和中序遍历不匹配
        if (i == inEnd) {
            root = null;
            return;
        }
        if (leftOrRight == LEFT) {
            sonRoot.left = new TreeNode(value);
            newRoot = sonRoot.left;
        } else {
            sonRoot.right = new TreeNode(value);
            newRoot = sonRoot.right;
        }
        buildTree(root, newRoot, pre, preStart + 1, preStart + 1 + leftLen, in, inStart, inStart + leftLen, LEFT);
        buildTree(root, newRoot, pre, preStart + 1 + leftLen, preEnd, in, inStart + leftLen + 1, inEnd, RIGHT);
    }

    // ====================测试代码====================
    public static void main(String[] args) {
        testForPreOrderAndInOrder();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }

    /**
     * 普通二叉树1：完全二叉树
     *      1
     *     / \
     *    2   3
     *   / \ / \
     *  4  5 6  7
     *  pre: 1,2,4,5,3,6,7
     *  in : 4,2,5,1,6,3,7
     */
    private static void test1() {
        System.out.println("==============test1==============");
        TreeNode root = _07_ConstructBinaryTree.reConstructBinaryTree(
                new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 2, 5, 1, 6, 3, 7});
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
    }

    /**
     * 普通二叉树2：不完全二叉树
     * 	    1
     *     / \
     *    2   3
     *   /     \
     *  4       7
     *  pre: 1,2,4,3,7
     *  in : 4,2,3,7,1
     */
    private static void test2() {
        System.out.println("==============test2==============");
        TreeNode root = _07_ConstructBinaryTree.reConstructBinaryTree(
                new int[]{1, 2, 4, 3, 7}, new int[]{4, 2, 3, 7, 1});
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
    }

    /**
     * 特殊二叉树1：所有 节点都没有右子节点的二叉树
     *       1
     *      /
     *     2
     *    /
     *   3
     *  /
     * 4
     * pre: 1,2,3,4
     * in : 4,3,2,1
     */
    private static void test3() {
        System.out.println("==============test3==============");
        TreeNode root = _07_ConstructBinaryTree.reConstructBinaryTree(
                new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1});
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
    }

    /**
     * 特殊二叉树2：所有 节点都没有左子节点的二叉树
     *        1
     *         \
     *          2
     *           \
     *            3
     *             \
     *              4
     * pre: 1,2,3,4
     * in : 1,2,3,4
     */
    private static void test4() {
        System.out.println("==============test4==============");
        TreeNode root = _07_ConstructBinaryTree.reConstructBinaryTree(
                new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
    }

    /**
     * 特殊二叉树3：只有一个节点的二叉树
     * 1
     * pre: 1
     * in : 1
     */
    private static void test5() {
        System.out.println("==============test5==============");
        TreeNode root = _07_ConstructBinaryTree.reConstructBinaryTree(
                new int[]{1}, new int[]{1});
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
    }

    /**
     * 特殊输入测试1：数组长度为0
     */
    private static void test6() {
        System.out.println("==============test6==============");
        TreeNode root = _07_ConstructBinaryTree.reConstructBinaryTree(
                new int[0], new int[0]);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
    }

    /**
     * 特殊输入测试2：前序和中序遍历不匹配
     * 	    1
     *     / \
     *    2   3
     *   /     \
     *  4       7
     *  pre: 1,2,4,3,7
     *  in : 4,2,3,7,6
     */
    private static void test7() {
        System.out.println("==============test7==============");
        TreeNode root = _07_ConstructBinaryTree.reConstructBinaryTree(
                new int[]{1, 2, 4, 3, 7}, new int[]{4, 2, 3, 7, 6});
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
    }


    /**
     * 前序遍历
     */
    private static void preOrder(TreeNode root) {
        if (root == null)
            return;
        int value = root.val;
        System.out.print(value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     */
    private static void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }


    /**
     *         1
     *       /   \
     *      2     3
     *     /     / \
     *    4     5   6
     *     \       /
     *      7     8
     *   preOrder: 1,2,4,7,3,5,6,8
     *   inOrder : 4,7,2,1,5,3,8,6
     */
    private static void testForPreOrderAndInOrder() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.right = node7;
        node6.left = node8;
        preOrder(node1);
        System.out.println();
        inOrder(node1);
        System.out.println();
    }
}