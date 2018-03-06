package com.wangyi.back;

import java.util.Scanner;

/**
 * 字符串碎片
 */
public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char cut = string.charAt(0);
        double count = 1;
        for (int i = 0; i < string.length(); i++) {
            if (cut != string.charAt(i)) {
                cut = string.charAt(i);
                count++;
            }
        }
        System.out.println(String.format("%.2f", string.length() / count));
    }
}
