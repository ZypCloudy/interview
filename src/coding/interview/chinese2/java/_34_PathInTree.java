package coding.interview.chinese2.java;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 面试题34：二叉树中和为某一值的路径
 * 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
 * 有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * <p>
 * 思路：
 * 使用前序遍历，然后用栈保存路径，并统计当前路径的sum。
 * 当某个节点已经不在路径内，这个节点要出栈，并从sum中减去对应的值。
 * ps:因为打印路径的时候需要遍历这个栈，所以这个栈结构最好能遍历。
 */
public class _34_PathInTree {

    public static class TreeNode {
        public int val = 0;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private int sum;
    LinkedList<Integer> stack;
    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return new ArrayList<>();
        stack = new LinkedList<>();
        result = new ArrayList<>();
        sum = 0;
        FindPathCore(root, target);
        return result;
    }

    private void FindPathCore(TreeNode root, int target) {
        sum += root.val;
        stack.addFirst(root.val);
        if (root.left != null)
            FindPathCore(root.left, target);
        if (root.right != null)
            FindPathCore(root.right, target);
        // 叶子节点
        if (root.left == null && root.right == null) {
            if (sum == target) {
                ArrayList<Integer> path = new ArrayList<>();
                for (int i = stack.size() - 1; i >= 0; --i) {
                    path.add(stack.get(i));
                }
                result.add(path);
            }
        }
        sum -= root.val;
        stack.removeFirst();
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * 功能测试
     *       8
     *      / \
     *     3   6
     *    / \ / \
     *   1  7 4  7
     *  /
     * 6
     */
    private static void test1() {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        _34_PathInTree pit = new _34_PathInTree();
        // 3条
        System.out.println(pit.FindPath(node1, 18));
        // 0条
        System.out.println(pit.FindPath(node1, 11));
    }

    /**
     * 边界测试
     * 1.只有一个节点
     */
    private static void test2() {
        TreeNode node1 = new TreeNode(1);
        _34_PathInTree pit = new _34_PathInTree();
        // 1条
        System.out.println(pit.FindPath(node1, 1));
        // 0条
        System.out.println(pit.FindPath(node1, 2));
    }

    /**
     * 极端测试
     * 1.头结点为空
     */
    private static void test3() {
        _34_PathInTree pit = new _34_PathInTree();
        // 0条
        System.out.println(pit.FindPath(null, 1));
    }
}