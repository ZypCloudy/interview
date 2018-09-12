package CodingInterviewChinese2.java;

/**
 * 面试题33：二叉搜索树的后序遍历序列
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 *
 * 例如，输入数组{5, 7, 6, 9, 11, 10, 8}，则返回true，因为这个整数序列是
 * 下面这个二叉搜索树的后序遍历结果。如果输入的数组是{7, 4, 6, 5}，则由于没有
 * 哪棵二叉搜索树的后序遍历结果是这个序列，因此返回false。
 *     8
 *    / \
 *   6  10
 *  / \ / \
 * 5  7 9 11
 * 
 * 思路：
 * 首先分析一下两个点：1.二叉搜索树   2.后续遍历
 * 注：题目表示无重复数字
 * 1.二叉搜索树的特点：左子节点 < 根节点 < 右子节点
 * 2.后续遍历的特点：遍历顺序为左->右->根，最后一个节点为树的根节点
 * 
 * 所以，符合题意的数组可以分成三个部分：
 * [{1.小于根节点},{2.大于根节点},3.根节点]
 * 然后1、2又是原问题的子问题
 * 所以可以递归解决
 */
public class _33_SequenceOfBST {

	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length == 0)
			return false;
		return VerifySequenceOfBST(sequence, 0, sequence.length - 1);
	}

	private boolean VerifySequenceOfBST(int[] sequence, int from, int to) {
		if (to - from <= 1)
			return true;

		int root = sequence[to];
		int preIndex = from;
		int lastIndex = to - 1;

		while (preIndex <= lastIndex) {
			if (sequence[preIndex] > root) {
				break;
			}
			++preIndex;
		}
		while (lastIndex >= from) {
			if (sequence[lastIndex] < root) {
				break;
			}
			--lastIndex;
		}

		if (preIndex == lastIndex + 1)
			return VerifySequenceOfBST(sequence, from, lastIndex) &&
					VerifySequenceOfBST(sequence, preIndex, to - 1);

		return false;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
	}

	/**
	 * 普通测试
	 * 1.完全二叉树
	 *      6
	 *   4    10
	 *  3 5  8  12
	 * 2.非完全二叉树
	 *      6
	 *   4    10
	 *  3    8
	 * 3.没有对应的二叉树
	 */
    private static void test1() {
        _33_SequenceOfBST sobst = new _33_SequenceOfBST();
        boolean b = sobst.VerifySquenceOfBST(new int[]{3, 5, 4, 8, 12, 10, 6});
        MyTest.equal(b, true);

        b = sobst.VerifySquenceOfBST(new int[]{3, 4, 8, 10, 6});
        MyTest.equal(b, true);

        b = sobst.VerifySquenceOfBST(new int[]{7, 4, 6, 5});
        MyTest.equal(b, false);
    }

	/**
	 * 边界测试
	 * 1.只有一个节点的二叉树
	 * 2.只有左子节点的二叉树
	 * 3.只有右子节点的二叉树
	 */
    private static void test2() {
        _33_SequenceOfBST sobst = new _33_SequenceOfBST();
        boolean b = sobst.VerifySquenceOfBST(new int[]{3});
        MyTest.equal(b, true);

        b = sobst.VerifySquenceOfBST(new int[]{1, 2, 6, 8});
        MyTest.equal(b, true);

        b = sobst.VerifySquenceOfBST(new int[]{8, 6, 2, 1});
        MyTest.equal(b, true);
    }

    /**
     * 极端测试
     * 1.输入null
     * 2.数组长度为0
     */
    private static void test3() {
        _33_SequenceOfBST sobst = new _33_SequenceOfBST();
        boolean b = sobst.VerifySquenceOfBST(null);
        MyTest.equal(b, false);

        b = sobst.VerifySquenceOfBST(new int[0]);
        MyTest.equal(b, false);
    }
}