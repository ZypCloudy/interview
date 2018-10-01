package com.scry.info.file;

import java.io.*;

/**
 * 写一个函数实现数据的读取或存储到文件功能，
 * 要求：
 * 一，文件名（包含路径）及数据都由函数参数提供；
 * 二，如果文件不存在，把数据写入文件中，返回空数据；
 * 三，如果文件中有数据，则返回旧数据，并使用新数据覆盖原来的数据；
 * 四，每次数据长度大于8byte
 *
 * 思路：先读文件，返回文件旧内容，再写文件。
 *
 * @author Cloudy
 */
public class HandleFlie {
    public static void main(String[] args) {
        String fileName = "E:\\test.txt";
        String content = "测试读写文件1\r\n测试读写文件2\r\n测试读写文件3";
        StringBuffer result = readAndWriteFile(fileName, content);
        System.out.println(result);
    }

    private static StringBuffer readAndWriteFile(String fileName, String content) {
        int bytes = 8;
        //每次数据长度大于8byte
        if (content.getBytes().length < bytes) {
            return null;
        }
        StringBuffer stringBuffer = readFileByLines(fileName);
        writeFile(fileName, content);
        return stringBuffer;
    }

    private static StringBuffer readFileByLines(String fileName) {
        File file = new File(fileName);
        StringBuffer sb = new StringBuffer();
        BufferedReader reader;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString + "\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    private static void writeFile(String fileName, String content) {
        try {
            //文件不存在，自动创建文件，默认路径为项目根目录
            FileOutputStream out = new FileOutputStream(new File(fileName));
            BufferedOutputStream buff = new BufferedOutputStream(out);
            buff.write(content.getBytes());
            buff.flush();
            buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
