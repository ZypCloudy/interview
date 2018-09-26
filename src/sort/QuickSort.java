package sort;

/**
 * 快速排序
 * <p>
 * 思路：
 * 选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
 * 递归的将p左边和右边的数都按照第一步进行，直到不能递归。
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] str = {4, 5, 1, 6, 2, 7, 3, 8};
        quickSort(str, 0, str.length - 1);
        Utils.print(str);
    }

    public static void quickSort(int[] numbers, int left, int right) {
        if (left < right) {
            // 选定的基准值（第一个数值作为基准值）
            int base = numbers[left];
            // 记录临时中间值
            int temp;
            int i = left, j = right;
            do {
                while ((numbers[i] < base) && (i < right)) {
                    i++;
                }
                while ((numbers[j] > base) && (j > left)) {
                    j--;
                }
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
                //第一次交换，3, 5, 1, 6, 2, 7, 4, 8
            } while (i <= j);
            //这一趟走完，3, 2, 1, 6, 5, 7, 4, 8
            if (left < j) {
                quickSort(numbers, left, j);
            }
            if (right > i) {
                quickSort(numbers, i, right);
            }
        }
    }
}
