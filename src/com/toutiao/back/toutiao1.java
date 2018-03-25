package com.toutiao.back;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class toutiao1 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        /**
         *  测试用例1
         *  5 2
         *  1 5 3 4 2
         *  输出3
         *  测试用例2
         *  6 2
         *  1 5 3 3 4 2
         *  输出3
         */
        findDiffNum(arr, k);
    }

    public static void findDiffNum(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return;
        HashSet<Integer> arrToSet = new HashSet<Integer>(arr.length);

        for (int i = 0; i < arr.length; i++) {
            arrToSet.add(arr[i]);
        }

        int sum, count = 0;
        for (Integer obj : arrToSet){
            sum = k + obj;
            if (arrToSet.contains(sum)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
