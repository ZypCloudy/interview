package CodingInterviewChinese2.java;

/**
 * 面试题26：树的子结构
 * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */
public class _26_SubStructureInTree {

    public static class TreeNode {
        public int val = 0;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        return findRootWithValue(root1, root2.val, root2);
    }

    /**
     * 遍历root1，当找到某个节点值与value相同时，遍历root2和子树root做比较
     */
    public boolean findRootWithValue(TreeNode root, int value, TreeNode root2) {
        if (root == null)
            return false;
        // 找到了根节点值一样的，并且root中包含root2
        if (root.val == value && compare(root2, root)) {
            return true;
        }

        return findRootWithValue(root.left, value, root2) ||
                findRootWithValue(root.right, value, root2);
    }

    public boolean compare(TreeNode root, TreeNode rootToBeCompared) {
        if (root == null)
            return true;
        if (rootToBeCompared == null)
            return false;
        if (root.val != rootToBeCompared.val)
            return false;

        return compare(root.left, rootToBeCompared.left) &&
                compare(root.right, rootToBeCompared.right);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    /**
     * 功能测试
     *     1
     *    / \
     *   2   3
     *  /\   /\
     * 4  5 6  7
     */
    private static void test1() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        _26_SubStructureInTree ssit = new _26_SubStructureInTree();
        boolean b = ssit.HasSubtree(root, node3);
        MyTest.equal(b, true);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(3);
        b = ssit.HasSubtree(root, root2);
        MyTest.equal(b, false);
    }

    /**
     * 边界测试
     * 1.root2只有一个节点
     */
    private static void test2() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        _26_SubStructureInTree ssit = new _26_SubStructureInTree();

        TreeNode root2 = new TreeNode(6);
        boolean b = ssit.HasSubtree(root, root2);
        MyTest.equal(b, true);

        TreeNode root3 = new TreeNode(8);
        b = ssit.HasSubtree(root, root3);
        MyTest.equal(b, false);
    }

    /**
     * 极端测试
     * 1.root1为 null
     * 2.root2为 null
     * 3.root1和root2都为null
     */
    private static void test3() {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        _26_SubStructureInTree ssit = new _26_SubStructureInTree();

        boolean b = ssit.HasSubtree(null, root2);
        MyTest.equal(b, false);

        b = ssit.HasSubtree(root1, null);
        MyTest.equal(b, false);

        b = ssit.HasSubtree(null, null);
        MyTest.equal(b, false);
    }

    /**
     * 第一次没通过的case
     */
    private static void test4() {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node5.right = node7;

        _26_SubStructureInTree ssit = new _26_SubStructureInTree();

        boolean b = ssit.HasSubtree(node1, node2);
        MyTest.equal(b, true);
    }
}















