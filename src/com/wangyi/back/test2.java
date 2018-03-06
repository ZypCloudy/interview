package com.wangyi.back;

import java.util.Scanner;

/**
 * 相反数
 */
public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(inverse(num));
        System.out.println(num + inverse(num));
    }
    public static int inverse(int num){
        int temp = 0;
        while (num > 0) {
            temp = temp * 10 + num % 10;
            num = num / 10;
        }
        return temp;
    }
}
