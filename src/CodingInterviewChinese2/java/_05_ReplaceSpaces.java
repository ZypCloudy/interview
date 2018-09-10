package CodingInterviewChinese2.java;

// 面试题5：替换空格
// 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
// 则输出“We%20are%20happy.”。
public class _05_ReplaceSpaces {
    /**
     * 方法一，新建一个字符串替换
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuffer str2 = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                str2.append('%');
                str2.append('2');
                str2.append('0');
            } else {
                str2.append(ch);
            }
        }
        return str2.toString();
    }

    /**
     * 方法二，直接操作原字符串替换
     * @param str
     * @return
     */
    public static String replaceBlank(StringBuffer str) {
        int oldLen = str.length();
        int len = oldLen;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ')
                len += 2;
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

    // ====================测试代码====================
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
        StringBuffer sb = new StringBuffer(" lin");
        String str = _05_ReplaceSpaces.replaceSpace(sb);
        MyTest.equal(str, "%20lin");

        sb = new StringBuffer("lin ");
        str = _05_ReplaceSpaces.replaceSpace(sb);
        MyTest.equal(str, "lin%20");

        sb = new StringBuffer("l in");
        str = _05_ReplaceSpaces.replaceSpace(sb);
        MyTest.equal(str, "l%20in");

        sb = new StringBuffer("  l  in  ");
        str = _05_ReplaceSpaces.replaceSpace(sb);
        MyTest.equal(str, "%20%20l%20%20in%20%20");
    }

    /**
     * 输入的字符串没有空格
     */
    private static void test2() {
        StringBuffer sb = new StringBuffer("lin");
        String str = _05_ReplaceSpaces.replaceSpace(sb);
        MyTest.equal(str, "lin");
    }

    /**
     * 特殊输入测试
     * 1.字符串长度为0
     * 2.字符串只有一个空格
     * 3.字符串中只有连续多个空格
     */
    private static void test3() {
        StringBuffer sb = new StringBuffer("");
        String str = _05_ReplaceSpaces.replaceSpace(sb);
        MyTest.equal(str, "");

        sb = new StringBuffer(" ");
        str = _05_ReplaceSpaces.replaceSpace(sb);
        MyTest.equal(str, "%20");

        sb = new StringBuffer("   ");
        str = _05_ReplaceSpaces.replaceSpace(sb);
        MyTest.equal(str, "%20%20%20");
    }
}
