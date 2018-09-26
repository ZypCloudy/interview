package coding.interview.chinese2.java;

/**
 * 面试题11：旋转数组的最小数字
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组
 * {3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
 */
public class _11_MinNumberInRotatedArray {
    private static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array[0] < array[array.length - 1]) {
            return array[0];
        }
        int midIndex = (array.length - 1) / 2;
        int midNum = array[midIndex];

        if (array[0] != midNum || (array[0] != array[array.length - 1])) {
            return findInBinary(array, 0, array.length - 1);
        } else {
            return findInSequence(array);
        }
    }

    private static int findInBinary(int[] array, int start, int end) {
        int midIndex = start + (end - start) / 2;
        if (midIndex == array.length || start == end) {
            return array[midIndex];
        }
        if (array[midIndex] > array[midIndex + 1]) {
            return array[midIndex + 1];
        } else if (array[midIndex] >= array[0]) {
            return findInBinary(array, midIndex + 1, end);
        } else {
            return findInBinary(array, start, midIndex);
        }
    }

    private static int findInSequence(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < array[i - 1]) {
                return array[i];
            }
        }
        return array[0];
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * 功能测试
     * Rotated: {1,2,3,4,5,6} -> {3,4,5,6,1,2}
     * Rotated: {1,2,3,4,5,6} -> {5,6,1,2,3,4}
     * Rotated: {0,1,1,1,1}  ->  {1,1,0,1,1}
     */
    private static void test1() {
        int[] arr1 = {3, 4, 5, 6, 1, 2};
        int min1 = _11_MinNumberInRotatedArray.minNumberInRotateArray(arr1);
        MyTest.equal(min1, 1);

        int[] arr2 = {5, 6, 1, 2, 3, 4};
        int min2 = _11_MinNumberInRotatedArray.minNumberInRotateArray(arr2);
        MyTest.equal(min2, 1);

        int[] arr3 = {1, 1, 0, 1, 1};
        int min3 = _11_MinNumberInRotatedArray.minNumberInRotateArray(arr3);
        MyTest.equal(min3, 0);
    }

    /**
     * 边界值测试
     * 1.没有rotate: {1,2,3,4,5}
     * 2.只有一个数：{1}
     * 3.所有元素都一样：{1,1,1,1}
     */
    private static void test2() {
        int[] arr1 = {2, 1};
        int min1 = _11_MinNumberInRotatedArray.minNumberInRotateArray(arr1);
        MyTest.equal(min1, 1);

        int[] arr2 = {1};
        int min2 = _11_MinNumberInRotatedArray.minNumberInRotateArray(arr2);
        MyTest.equal(min2, 1);

        int[] arr3 = {1, 1, 1, 1};
        int min3 = _11_MinNumberInRotatedArray.minNumberInRotateArray(arr3);
        MyTest.equal(min3, 1);
    }
}
