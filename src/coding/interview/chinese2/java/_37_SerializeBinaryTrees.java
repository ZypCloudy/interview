package coding.interview.chinese2.java;

/**
 * 面试题37：序列化二叉树
 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class _37_SerializeBinaryTrees {

    public static class TreeNode {
        public int val = 0;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 序列化
     */
    public String Serialize(TreeNode root) {
        if (root == null)
            return "$";
        StringBuilder sb = new StringBuilder();
        Serialize(root, sb);
        return sb.toString();
    }

    private void Serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("$");
            return;
        }
        sb.append(root.val);
        Serialize(root.left, sb.append(","));
        Serialize(root.right, sb.append(","));
    }


    private int index;

    /**
     * 反序列化
     */
    public TreeNode Deserialize(String str) {
        if (str == null || str.trim().length() == 0)
            return null;
        String[] nums = str.split(",");
        index = 0;
        return Deserialize(nums);
    }

    public TreeNode Deserialize(String[] nums) {
        if (nums[index].equals("$")) {
            ++index;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(nums[index++]));
        node.left = Deserialize(nums);
        node.right = Deserialize(nums);
        return node;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * 功能测试
     * 1.序列化
     *     1
     *    / \
     *   2   3
     *  /   / \
     * 4   5   6
     *
     * 2.反序列化
     */
    private static void test1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        _37_SerializeBinaryTrees sbt = new _37_SerializeBinaryTrees();
        String s = sbt.Serialize(node1);
        // 1,2,4,$,$,$,3,5,$,$,6,$,$
        System.out.println(s);

        TreeNode newRoot = sbt.Deserialize(s);
        String s2 = sbt.Serialize(newRoot);
        // 1,2,4,$,$,$,3,5,$,$,6,$,$
        System.out.println(s);
    }

    /**
     * 边界测试
     * 1.只有左子节点
     * 2.只有右子节点
     * 3.只有一个节点
     */
    private static void test2() {
        _37_SerializeBinaryTrees sbt = new _37_SerializeBinaryTrees();
        TreeNode root1 = sbt.Deserialize("1,2,3,$,$,$,$");
        System.out.println(sbt.Serialize(root1));

        TreeNode root2 = sbt.Deserialize("1,$,2,$,3,$,$");
        System.out.println(sbt.Serialize(root2));

        TreeNode root3 = sbt.Deserialize("1,$,$");
        System.out.println(sbt.Serialize(root3));
    }

    /**
     * 极端测试
     * 1.反序列化时输入空字符串
     * 2.序列化时输入null
     */
    private static void test3() {
        _37_SerializeBinaryTrees sbt = new _37_SerializeBinaryTrees();
        TreeNode root = sbt.Deserialize("");
        System.out.println(sbt.Serialize(root));
    }
}














