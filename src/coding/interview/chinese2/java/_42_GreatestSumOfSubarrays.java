package coding.interview.chinese2.java;

/**
 * 面试题42：连续子数组的最大和
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整
 * 数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * <p>
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 * <p>
 * 这道题之前在某本书的第一题看过，思路懂了结题就很简单了。
 * 思路：
 * 1.保存两个值，一个sum，一个max，sum初始化为0，max初始化为数组第一个元素
 * 2.从下标0开始遍历，sum += 遍历到的元素。
 * 如果sum > 0，则与max比较，如果大于max则max=sum
 * 如果sum <= 0，则与max比较，如果大于max则max=sum，并把sum置于0
 */
public class _42_GreatestSumOfSubarrays {

    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int sum = 0;
        int max = array[0];
        for (int i : array) {
            if (sum < 0)
                sum = i;
            else
                sum += i;
            if (sum > max)
                max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * 功能测试
     */
    private static void test1() {
        int res = _42_GreatestSumOfSubarrays.
                FindGreatestSumOfSubArray(new int[]{1, -2, 1, 3, 4, -2, 5, -1});
        MyTest.equal(res, 11);
    }

    /**
     * 边界测试
     * 1.全正数
     * 2.全负数
     * 3.只有一个数
     */
    private static void test2() {
        int res = _42_GreatestSumOfSubarrays.
                FindGreatestSumOfSubArray(new int[]{1, 2, 1, 3});
        MyTest.equal(res, 7);

        res = _42_GreatestSumOfSubarrays.FindGreatestSumOfSubArray(new int[]{-1, -2, -1, -3});
        MyTest.equal(res, -1);

        res = _42_GreatestSumOfSubarrays.FindGreatestSumOfSubArray(new int[]{3});
        MyTest.equal(res, 3);
    }

    /**
     * 极端测试
     * 1.输入null
     * 2.数组长度0
     */
    private static void test3() {
        int res = _42_GreatestSumOfSubarrays.FindGreatestSumOfSubArray(null);
        MyTest.equal(res, 0);

        res = _42_GreatestSumOfSubarrays.FindGreatestSumOfSubArray(new int[0]);
        MyTest.equal(res, 0);
    }
}











