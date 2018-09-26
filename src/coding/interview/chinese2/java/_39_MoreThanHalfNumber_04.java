package coding.interview.chinese2.java;

/**
 * 面试题39：数组中出现次数超过一半的数字
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
 * 如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
 * 出现了5次，超过数组长度的一半，因此输出2。
 * <p>
 * 解法4：根据数组特点找出时间复杂度为O(n)的算法
 * 数组中有一个数字出现的次数超过数组长度的一半，说明它出现的次数比其他所有数字出现的次数和还要多。
 * <p>
 * 因此我们可以使用以下解法：
 * 1.保存两个值：一个是数组中的一个数字val，一个是次数count。
 * 2.当我们遍历到下一个数字时，
 * if count=0，则val设置为当前数字，count设置为1；
 * else if 这个数字和val相同，则count+1；
 * else count-1；
 * <p>
 * 由于我们要找的数字出现的次数比其他所有数字出现的次数和多，
 * 那么要找的数字肯定是最后一次把数组设置为1时对应的数字，即val可能就是我们要的值
 * 之所以说是可能，是因为还要验证val出现的次数是否真正超过了数组长度的一半
 */
public class _39_MoreThanHalfNumber_04 {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int val = 0;
        int count = 0;
        for (int i : array) {
            if (count == 0) {
                val = i;
                count = 1;
            } else if (val == i)
                ++count;
            else
                --count;
        }
        if (checkMoreThanHalf(array, val))
            return val;
        return 0;
    }

    private boolean checkMoreThanHalf(int[] array, int val) {
        int count = 0;
        for (int i : array) {
            if (i == val)
                ++count;
        }
        return count > array.length / 2;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * 功能测试
     * 1.存在
     * 2.不存在
     */
    private static void test1() {
        _39_MoreThanHalfNumber_04 m = new _39_MoreThanHalfNumber_04();
        int res = m.MoreThanHalfNum_Solution(new int[]{2, 4, 1, 3, 4, 4, 1, 4, 4, 6, 4});
        MyTest.equal(res, 4);

        res = m.MoreThanHalfNum_Solution(new int[]{2, 4, 1, 3, 4, 4, 1, 4, 4, 6});
        MyTest.equal(res, 0);
    }

    /**
     * 边界测试
     * 1.只有一个元素
     */
    private static void test2() {
        _39_MoreThanHalfNumber_04 m = new _39_MoreThanHalfNumber_04();
        int res = m.MoreThanHalfNum_Solution(new int[]{2});
        MyTest.equal(res, 2);
    }

    /**
     * 极端测试
     * 1.输入null
     * 2.输入数组长度为0
     */
    private static void test3() {
        _39_MoreThanHalfNumber_04 m = new _39_MoreThanHalfNumber_04();
        int res = m.MoreThanHalfNum_Solution(null);
        MyTest.equal(res, 0);

        res = m.MoreThanHalfNum_Solution(new int[0]);
        MyTest.equal(res, 0);
    }
}