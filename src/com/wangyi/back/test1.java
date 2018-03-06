package com.wangyi.back;

import java.util.Scanner;

/**
 * 魔法币
 */
public class test1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        String re = "";

        re = magic(n, re);

        for (int i = re.length() - 1; i >= 0; i--) {

            System.out.print(re.charAt(i));

        }
    }

    public static String magic(int n, String re) {

        while (n > 0) {

            if (n % 2 == 0) {

                re += '2';

                n = (n - 2) / 2;

            } else {

                re += '1';

                n = (n - 1) / 2;
            }
        }
        return re;
    }
}
