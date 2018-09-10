package CodingInterviewChinese2.java;

// 面试题4：二维数组中的查找
// 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
// 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
// 整数，判断数组中是否含有该整数。
public class _04_FindInPartiallySortedMatrix {
    public static boolean Find(int target, int[][] array) {
        // 不做这个判断的话，在y=array[0].length-1时会抛出异常
        if (array.length == 0)
            return false;
        boolean found = false;//设置标志位
        int rows = array.length;//获取行数
        int colms = array[0].length;//获取列数
        if (array != null && rows > 0 && colms > 0) {
            int row = 0;//从第一行开始
            int colm = colms - 1;//从最后一列开始
            while (row < rows && colm >= 0) {
                if (array[row][colm] == target) {
                    found = true;
                    break;
                } else if (array[row][colm] > target) {
                    colm--;
                } else {
                    row++;
                }
            }
        }
        return found;
    }

    // ====================测试代码====================
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        test1(array);
        test2(array);
        test3();
    }

    /**
     * 二维数组中包含查找的数字
     * 1.查找的数字是数组中最大值
     * 2.查找的数字是数组中最小值
     * 3.查找的数字介于数组中的最大值和最小值之间
     */
    private static void test1(int[][] array) {
        boolean isFind = _04_FindInPartiallySortedMatrix.Find(1, array);
        MyTest.equal(isFind, true);
        isFind = _04_FindInPartiallySortedMatrix.Find(15, array);
        MyTest.equal(isFind, true);
        isFind = _04_FindInPartiallySortedMatrix.Find(10, array);
        MyTest.equal(isFind, true);
    }

    /**
     * 二维数组中没有查找的数字
     * 1.查找的数字大于数组中的最大值
     * 2.查找的数字小于数组中的最小值
     * 3.查找的数字在数组中的最大值和最小值之间但数组没有这个数字
     */
    private static void test2(int[][] array) {
        boolean isFind = _04_FindInPartiallySortedMatrix.Find(0, array);
        MyTest.equal(isFind, false);
        isFind = _04_FindInPartiallySortedMatrix.Find(16, array);
        MyTest.equal(isFind, false);
        isFind = _04_FindInPartiallySortedMatrix.Find(5, array);
        MyTest.equal(isFind, false);
    }

    /**
     * 特殊输入测试，输入空数组
     */
    private static void test3() {
        int[][] arr = new int[0][0];
        boolean isFind = _04_FindInPartiallySortedMatrix.Find(1, arr);
        MyTest.equal(isFind, false);
    }
}
