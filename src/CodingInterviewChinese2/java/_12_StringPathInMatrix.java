package CodingInterviewChinese2.java;

/**
 * 面试题12：矩阵中的路径
 * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
 * 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
 * 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
 * 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
 * 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
 * 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * A B T G
 * C F C S
 * J D E H
 */
public class _12_StringPathInMatrix {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || str == null || matrix.length == 0 || str.length == 0)
            return false;

        int len = matrix.length;
        boolean[] flags = new boolean[len];

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (matrix[r * cols + c] == str[0]) {
                    if (hasPath(matrix, rows, cols, r, c, str, 0, flags)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean hasPath(char[] matrix, int rows, int cols, int r, int c,
                            char[] str, int index, boolean[] flags) {
        if (index == str.length)
            return true;
        if (r >= rows || r < 0 || c >= cols || c < 0)
            return false;
        if (flags[r * cols + c] == true || matrix[r * cols + c] != str[index])
            return false;

        flags[r * cols + c] = true;

        boolean hp = hasPath(matrix, rows, cols, r + 1, c, str, index + 1, flags) ||
                hasPath(matrix, rows, cols, r - 1, c, str, index + 1, flags) ||
                hasPath(matrix, rows, cols, r, c + 1, str, index + 1, flags) ||
                hasPath(matrix, rows, cols, r, c - 1, str, index + 1, flags);

        if (hp == true)
            return true;

        flags[r * cols + c] = false;

        return false;
    }

    // ====================测试代码====================
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * a  b  t  g
     * c  f  c  s
     * j  d  e  h
     * <p>
     * 是否包含bfce: true
     * 是否包含abfb: false
     */
    private static void test1() {
        _12_StringPathInMatrix spim = new _12_StringPathInMatrix();
        char[] matrix = {'a', 'b', 't', 'g',
                'c', 'f', 'c', 's',
                'j', 'd', 'e', 'h'};
        int rows = 3;
        int cols = 4;
        boolean result1 = spim.hasPath(matrix, rows, cols, new char[]{'b', 'f', 'c', 'e'});
        MyTest.equal(result1, true);

        boolean result2 = spim.hasPath(matrix, rows, cols, new char[]{'a', 'b', 'f', 'b'});
        MyTest.equal(result2, false);
    }

    /**
     * 极端值测试
     * 1.matrix数组大小为0
     * 2.str数组大小为0
     * 3.matrix为null
     * 4.str为null
     */
    private static void test2() {
        _12_StringPathInMatrix spim = new _12_StringPathInMatrix();
        char[] matrix1 = new char[0];
        boolean result1 = spim.hasPath(matrix1, 0, 0, new char[]{'1'});
        MyTest.equal(result1, false);

        char[] matrix2 = new char[]{'h', 'h', 'h', 'h'};
        boolean result2 = spim.hasPath(matrix2, 2, 2, new char[0]);
        MyTest.equal(result2, false);

        boolean result3 = spim.hasPath(null, 0, 0, new char[0]);
        MyTest.equal(result3, false);

        char[] matrix4 = new char[]{'h', 'h', 'h', 'h'};
        ;
        boolean result4 = spim.hasPath(matrix4, 2, 2, null);
        MyTest.equal(result4, false);
    }

    /**
     * 边界测试
     * 1.只有一行
     * 2.只有一列
     * 3.矩阵所有字母一样
     */
    private static void test3() {
        _12_StringPathInMatrix spim = new _12_StringPathInMatrix();
        char[] matrix1 = {'1', '2', '3', '4'};
        boolean result1 = spim.hasPath(matrix1, 4, 1, new char[]{'4', '3', '2', '1'});
        MyTest.equal(result1, true);

        char[] matrix2 = {'1', '2', '3', '4'};
        boolean result2 = spim.hasPath(matrix2, 1, 4, new char[]{'2', '3', '4'});
        MyTest.equal(result2, true);

        char[] matrix3 = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'};
        boolean result3 = spim.hasPath(matrix3, 3, 3, new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'});
        MyTest.equal(result3, true);
    }
}
