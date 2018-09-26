package coding.interview.chinese2.java;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 面试题38：字符串的排列
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，
 * 则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 * ps：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class _38_StringPermutation {

    TreeSet<String> set;

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.trim().length() == 0)
            return new ArrayList<>();
        char[] chars = str.toCharArray();
        set = new TreeSet<>();
        Permutation(chars, 0);
        return new ArrayList<>(set);
    }

    private void Permutation(char[] chars, int index) {
        if (index == chars.length - 1) {
            set.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; ++i) {
            swap(chars, i, index);
            Permutation(chars, index + 1);
            swap(chars, i, index);
        }
    }

    private void swap(char[] chars, int indexA, int indexB) {
        char c = chars[indexA];
        chars[indexA] = chars[indexB];
        chars[indexB] = c;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * 功能测试
     * 1.有重复字符
     * 2.无重复字符
     */
    private static void test1() {
        _38_StringPermutation sp = new _38_StringPermutation();
        System.out.println(sp.Permutation("abc"));
        System.out.println(sp.Permutation("aAb"));
        System.out.println(sp.Permutation("aabc"));
    }

    /**
     * 边界测试
     * 1.只有一个字符
     * 2.有多个重复字符
     */
    private static void test2() {
        _38_StringPermutation sp = new _38_StringPermutation();
        System.out.println(sp.Permutation("a"));
        System.out.println(sp.Permutation("aaa"));
        System.out.println(sp.Permutation("aabb"));
    }

    /**
     * 极端测试
     * 1.输入null
     * 2.输入的字符串内容为空
     */
    private static void test3() {
        _38_StringPermutation sp = new _38_StringPermutation();
        System.out.println(sp.Permutation(null));
        System.out.println(sp.Permutation(""));
    }
}










