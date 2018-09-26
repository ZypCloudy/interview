package coding.interview.chinese2.java;

/**
 * 面试题27：二叉树的镜像
 * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 二叉树的镜像定义：
 * 源二叉树：
 *   	    8
 *   	   /  \
 *   	  6   10
 *   	 / \  / \
 *   	5  7 9  11
 *
 * 镜像二叉树：
 *   	     8
 *   	   /   \
 *   	  10    6
 *   	 / \   / \
 *   	11  9 7   5
 */
public class _27_MirrorOfBinaryTree {

    public static class TreeNode {
        public int val = 0;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
    //功能测试：
    //  1.普通二叉树
    //
    //  边界测试：
    //  1.二叉树的节点都没有左子树
    //  2.二叉树的节点都没有右子树
    //  3.只有一个节点的二叉树
    //
    //  极端测试：
    //  1.二叉树的根节点为null
}














