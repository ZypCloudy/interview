package coding.interview.chinese2.java;


/**
 * 面试题8：二叉树的下一个结点
 * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 * 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 */
public class _08_NextNodeInBinaryTrees {
    public static class TreeLinkNode {
        public int val;
        public TreeLinkNode left = null;
        public TreeLinkNode right = null;
        public TreeLinkNode parent = null;
        public TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 首先判断node是否有右子树？
     *   ->有右子树则返回右子树中最左的节点
     *   没有右子树的话判断node是否为父节点的左子节点？
     *     ->是的话直接返回父节点
     *     不是的话则沿着父节点往上（parent）寻找，
     *     直到某个节点node2，node2为其父节点node3的左子节点，返回node3
     *
     * @param pNode 节点
     * @return 中序遍历的下一个节点
     */
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if(pNode == null) {
            return null;
        }
        // 右子树不为空
        if(pNode.right != null) {
            return findLeft(pNode.right);
        }
        // 是父节点的左子节点
        if(pNode.parent != null && pNode == pNode.parent.left) {
            return pNode.parent;
        }
        TreeLinkNode cur = pNode;
        while(cur.parent != null && cur != cur.parent.left) {
            cur = cur.parent;
        }
        // 遍历到了根节点还是没找到
        if(cur.parent == null) {
            return null;
        }
        return cur.parent;
    }

    private TreeLinkNode findLeft(TreeLinkNode pNode) {
        TreeLinkNode cur = pNode;
        while(cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     *             1
     *          /     \
     *         2       3
     *        / \     / \
     *       4   5   6   7
     *          / \
     *         8   9
     *
     *  有右子树：2  ->  8
     *  没有右子树 & 为父节点的左子节点: 6  ->  3
     *  没有右子树 & 非父节点的左子节点: 7  ->  null, 9  ->  1
     *
     *  前序：1,2,4,5,8,9,3,6,7
     *  中序：4,2,8,5,9,1,6,3,7
     */
    private static void test1() {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        TreeLinkNode n8 = new TreeLinkNode(8);
        TreeLinkNode n9 = new TreeLinkNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;

        n2.parent = n1;
        n3.parent = n1;
        n4.parent = n2;
        n5.parent = n2;
        n6.parent = n3;
        n7.parent = n3;
        n8.parent = n5;
        n9.parent = n5;

        _08_NextNodeInBinaryTrees nnibt = new _08_NextNodeInBinaryTrees();

        // 有右子树
        TreeLinkNode tn1 = nnibt.getNext(n2);
        System.out.println(tn1 == n8);

        // 没有右子树 & 为父节点的左子节点
        TreeLinkNode tn2 = nnibt.getNext(n6);
        System.out.println(tn2 == n3);

        // 没有右子树 & 非父节点的左子节点
        TreeLinkNode tn3 = nnibt.getNext(n7);
        System.out.println(tn3 == null);

        // 没有右子树 & 非父节点的左子节点
        TreeLinkNode tn4 = nnibt.getNext(n9);
        System.out.println(tn4 == n1);
    }

    /**
     * 只有一个节点
     */
    private static void test2() {
        _08_NextNodeInBinaryTrees nnibt = new _08_NextNodeInBinaryTrees();
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode node = nnibt.getNext(root);
        System.out.println(node == null);
    }

    /**
     * 树为空
     */
    private static void test3() {
        _08_NextNodeInBinaryTrees nnibt = new _08_NextNodeInBinaryTrees();
        TreeLinkNode root = null;
        TreeLinkNode node = nnibt.getNext(root);
        System.out.println(node == null);
    }
}
