package coding.interview.chinese2.java;

/**
 * 面试题5：替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
 * 则输出“We%20are%20happy.”。
 *
 * 方法一
 * 思路：
 * 新建一个StringBuffer，遇到一个空格就添加%20
 *
 * @author zhangyp
 */
public class _05_ReplaceSpaces_01 {
    private static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            } else {
                newStr.append(ch);
            }
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * 输入的字符串中包含空格
     * 1.空格位于字符串的最前面
     * 2.空格位于字符串的最后面
     * 3.空格位于字符串的中间
     * 3.字符串中有连续多个空格
     */
    private static void test1() {
        StringBuffer sb = new StringBuffer(" We");
        String str = _05_ReplaceSpaces_01.replaceSpace(sb);
        MyTest.equal(str, "%20We");

        sb = new StringBuffer("We ");
        str = _05_ReplaceSpaces_01.replaceSpace(sb);
        MyTest.equal(str, "We%20");

        sb = new StringBuffer("We are");
        str = _05_ReplaceSpaces_01.replaceSpace(sb);
        MyTest.equal(str, "We%20are");

        sb = new StringBuffer("We are happy.");
        str = _05_ReplaceSpaces_01.replaceSpace(sb);
        MyTest.equal(str, "We%20are%20happy.");
    }

    /**
     * 输入的字符串没有空格
     */
    private static void test2() {
        StringBuffer sb = new StringBuffer("We");
        String str = _05_ReplaceSpaces_01.replaceSpace(sb);
        MyTest.equal(str, "We");
    }

    /**
     * 特殊输入测试
     * 1.字符串长度为0
     * 2.字符串只有一个空格
     * 3.字符串中只有连续多个空格
     */
    private static void test3() {
        StringBuffer sb = new StringBuffer("");
        String str = _05_ReplaceSpaces_01.replaceSpace(sb);
        MyTest.equal(str, "");

        sb = new StringBuffer(" ");
        str = _05_ReplaceSpaces_01.replaceSpace(sb);
        MyTest.equal(str, "%20");

        sb = new StringBuffer("   ");
        str = _05_ReplaceSpaces_01.replaceSpace(sb);
        MyTest.equal(str, "%20%20%20");
    }
}
