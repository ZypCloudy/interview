package CodingInterviewChinese2.java;

import java.util.ArrayList;

/**
 * 面试题29：顺时针打印矩阵
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 例如，如果输入如下矩阵：
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class _29_PrintMatrix {

	/**
	 * ———————————>
	 * ↑          |
	 * |          |
	 * |          |
	 * <——————————↓ 
	 */
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 ||
				matrix[0] == null || matrix[0].length == 0)
			return null;
		ArrayList<Integer> list = new ArrayList<>();
		int row = matrix.length - 1;    // 未遍历的行下标最大值
		int col = matrix[0].length - 1;    // 未遍历的列下标最大值
		// start表示未遍历的行/列下标的最小值
		for (int start = 0; start <= row && start <= col; ++start, --row, --col) {
			for (int i = start; i <= col; ++i) {                // 上
				list.add(matrix[start][i]);
			}
			for (int i = start + 1; i <= row; ++i) {        // 右
				list.add(matrix[i][col]);
			}
			if (start < row) {
				for (int i = col - 1; i >= start; --i) {    // 下
					list.add(matrix[row][i]);
				}
			}
			if (start < col) {
				for (int i = row - 1; i > start; --i) {    // 左
					list.add(matrix[i][start]);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	/**
	 * 数组有多行多列
	 */
	private static void test1() {
		_29_PrintMatrix pm = new _29_PrintMatrix();
		int[][] arr = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}
		};
		System.out.println(pm.printMatrix(arr));

		arr = new int[][]{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
				{10, 11, 12},
				{13, 14, 15}
		};
		System.out.println(pm.printMatrix(arr));
	}

	/**
	 * 边界测试
	 * 1.数组只有一行
	 * 2.数组只有一列
	 * 3.数组只有一行一列
	 */
	private static void test2() {
		_29_PrintMatrix pm = new _29_PrintMatrix();
		System.out.println(pm.printMatrix(new int[][]{{1, 2, 3, 4}}));
		System.out.println(pm.printMatrix(new int[][]{{1}, {2}, {3}, {4}}));
		System.out.println(pm.printMatrix(new int[][]{{1}}));
	}

	/**
	 * 极端测试
	 * 1.二维数组为null
	 * 2.二维数组第一维度有0个元素
	 * 4.二维数组第二维度为null
	 * 3.二维数组第二维度为0个元素
	 */
	private static void test3() {
		_29_PrintMatrix pm = new _29_PrintMatrix();
		System.out.println(pm.printMatrix(null));

		System.out.println(pm.printMatrix(new int[0][]));

		System.out.println(pm.printMatrix(new int[6][]));

		System.out.println(pm.printMatrix(new int[3][0]));
	}
}
















