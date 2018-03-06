package com.wangyi.back;

import java.util.Scanner;

/**
 * 游历魔法王国
 */
public class test4 {
    static int n;
    static int[] parent;
    static int l;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        l = in.nextInt();
        parent = new int[n];
        in.nextLine();
        for (int i = 0; i < n - 1; i++)
            parent[i] = in.nextInt();
        System.out.println(work());
    }

    public static int work() {
        int[] dp = new int[n];
        int mx = 0;
        for (int i = 0; i < n - 1; i++) {
            dp[i + 1] = dp[parent[i]] + 1;
            mx = Math.max(mx, dp[i + 1]);
        }
        int d = Math.min(l, mx);
        return Math.min(n, 1 + d + (l - d) / 2);
    }
}
