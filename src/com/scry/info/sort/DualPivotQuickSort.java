package com.scry.info.sort;

public class DualPivotQuickSort {
    public static void main(String[] args) {
        int[] testItems = new int[20];
        for (int i = 0; i < testItems.length; i++) {
            testItems[i] = (int) (Math.random() * 100);
            System.out.print(testItems[i] + " ");
        }
        dualPivotQuickSort(testItems);
        System.out.println();
        for (int i = 0; i < testItems.length; i++) {
            System.out.print(testItems[i] + " ");
        }
    }

    public static void dualPivotQuickSort(int[] items) {
        dualPivotQuickSort(items, 0, items.length - 1);
    }

    public static void dualPivotQuickSort(int[] items, int start, int end) {
        if (start < end) {
            if (items[start] > items[end]) {
                swap(items, start, end);
            }
            int pivot1 = items[start], pivot2 = items[end];
            int i = start, j = end, k = start + 1;
            while (k < j) {
                if (items[k] < pivot1) {
                    swap(items, ++i, k++);
                } else if (items[k] <= pivot2) {
                    k++;
                } else {
                    while (items[--j] > pivot2) {
                        if (j <= k) {
                            // 扫描终止
                            break;
                        }
                    }

                    if (items[j] < pivot1) {
                        swap(items, j, k);
                        swap(items, ++i, k);
                    } else {
                        swap(items, j, k);
                    }
                    k++;
                }
            }
            swap(items, start, i);
            swap(items, end, j);

            dualPivotQuickSort(items, start, i - 1);
            dualPivotQuickSort(items, i + 1, j - 1);
            dualPivotQuickSort(items, j + 1, end);
        }
    }

    private static void swap(int[] items, int i, int j) {
        int temp;
        temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
}
