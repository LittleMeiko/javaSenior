package com.atguigu.java;

import org.junit.Test;

import java.io.*;
import java.util.Objects;

/**
 * 处理流之二：转换流的使用
 * 1.转换流属于：字符流
 *  InputStreamReader:将一个字节的输入流转换成一个字符的输入流
 *  OutputStreamWriter:将一个字符的输出流转换成一个字节的输出流
 *
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3.解码：字节、字节数组 --> 字符数组、字符串
 *   编码：字符数组、字符串 --> 字节、字节数组
 *
 * 4.字符集
 *
 */
public class InputStreamReaderTest {

    @Test
    public void testInputOutput() throws IOException {
        File srcFile = new File("note.txt");
        File gbkFile = new File("note_gbk.txt");

        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(gbkFile);

        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");

        int len;
        char[] cbuf = new char[20];
        while((len = isr.read(cbuf)) != -1) {
            osw.write(cbuf, 0, len);
        }

        osw.close();
        isr.close();
    }

    @Test
    public void inputReaderTest() {
        InputStreamReader isr = null;

        try {
            isr = new InputStreamReader(new FileInputStream("note.txt"), "UTF-8");
            int len;
            char[] cbuf = new char[20];
            while ((len = isr.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(isr)) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
