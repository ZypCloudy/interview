package coding.interview.chinese2.java;

/**
 * 面试题13：机器人的运动范围
 * 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
 * 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
 * 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
 * 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class _13_RobotMove {
    public int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0 || threshold < 0)
            return 0;

        boolean[][] visited = new boolean[rows][cols];

        return movingCount(threshold, rows, cols, 0, 0, visited);
    }

    private int movingCount(int threshold, int rows, int cols, int r, int c, boolean[][] visited) {

        if (r >= rows || r < 0 || c >= cols || c < 0)
            return 0;
        if (visited[r][c] || isBiggerThanThreshold(r, c, threshold))
            return 0;

        visited[r][c] = true;

        return 1 + movingCount(threshold, rows, cols, r + 1, c, visited) +
                movingCount(threshold, rows, cols, r - 1, c, visited) +
                movingCount(threshold, rows, cols, r, c + 1, visited) +
                movingCount(threshold, rows, cols, r, c - 1, visited);
    }

    private boolean isBiggerThanThreshold(int r, int c, int threshold) {
        int sum = 0;
        while (r > 0) {
            sum += r % 10;
            r /= 10;
        }
        while (c > 0) {
            sum += c % 10;
            c /= 10;
        }
        return sum > threshold;
    }

    // ====================测试代码====================
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * 功能测试
     * 0,0  0,1  0,2  0,3
     * 1,0  1,1  1,2  1,3
     * 2,0  2,1  2,2  2,3
     */
    private static void test1() {
        _13_RobotMove rm = new _13_RobotMove();
        int res = rm.movingCount(3, 3, 4);
        MyTest.equal(res, 9);
    }

    /**
     * 边界值测试
     * 1.只有一行
     * 2.只有一列
     * 3.k等于0
     */
    private static void test2() {
        _13_RobotMove rm = new _13_RobotMove();
        // 0-9, 10-18
        int res = rm.movingCount(9, 30, 1);
        MyTest.equal(res, 19);

        // 0-9, 10-18
        res = rm.movingCount(9, 1, 30);
        MyTest.equal(res, 19);

        res = rm.movingCount(0, 2, 4);
        MyTest.equal(res, 1);
    }

    /**
     * 特殊输入测试
     */
    private static void test3() {
        _13_RobotMove rm = new _13_RobotMove();
        int res = rm.movingCount(-1, 4, 4);
        MyTest.equal(res, 0);
    }
}
