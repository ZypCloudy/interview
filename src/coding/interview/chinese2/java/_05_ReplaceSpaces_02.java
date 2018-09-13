package coding.interview.chinese2.java;

/**
 * 面试题5：替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
 * 则输出“We%20are%20happy.”。
 *
 * 方法二
 * 思路：
 * 操作原字符串
 * 1. 首先遍历，找到空格，扩大字符串长度(一个空格长度+2，因为原来有一个空格占位符)
 * 2. 再从后往前遍历，原字符串和扩大后的长度，一起遍历
 * 3. 遇到非空格则把字符放在扩大后的字符串的位置
 * 4. 遇到空格，则在扩大后的字符串放入%20
 *
 * @author zhangyp
 */
public class _05_ReplaceSpaces_02 {
    private static String replaceSpace(StringBuffer str) {
        int oldLen = str.length();
        int len = oldLen;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ') {
                len += 2;
            }
        }
        str.setLength(len);

        for (int i = oldLen - 1, j = len - 1; i >= 0; ) {
            if (str.charAt(i) == ' ') {
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j--, '%');
                --i;
            } else {
                str.setCharAt(j--, str.charAt(i--));
            }
        }
        return str.toString();
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
        String str = _05_ReplaceSpaces_02.replaceSpace(sb);
        MyTest.equal(str, "%20We");

        sb = new StringBuffer("We ");
        str = _05_ReplaceSpaces_02.replaceSpace(sb);
        MyTest.equal(str, "We%20");

        sb = new StringBuffer("We are");
        str = _05_ReplaceSpaces_02.replaceSpace(sb);
        MyTest.equal(str, "We%20are");

        sb = new StringBuffer("We are happy.");
        str = _05_ReplaceSpaces_02.replaceSpace(sb);
        MyTest.equal(str, "We%20are%20happy.");
    }

    /**
     * 输入的字符串没有空格
     */
    private static void test2() {
        StringBuffer sb = new StringBuffer("We");
        String str = _05_ReplaceSpaces_02.replaceSpace(sb);
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
        String str = _05_ReplaceSpaces_02.replaceSpace(sb);
        MyTest.equal(str, "");

        sb = new StringBuffer(" ");
        str = _05_ReplaceSpaces_02.replaceSpace(sb);
        MyTest.equal(str, "%20");

        sb = new StringBuffer("   ");
        str = _05_ReplaceSpaces_02.replaceSpace(sb);
        MyTest.equal(str, "%20%20%20");
    }
}
