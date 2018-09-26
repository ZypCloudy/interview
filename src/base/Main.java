package base;

import java.util.Scanner;

/**
 * 1~n 素数
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;
        for (int i = 1; i <= N; i++) {
            int j;
            for (j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j == i) {
                count++;
            }
        }
        System.out.println(count);
    }
}
