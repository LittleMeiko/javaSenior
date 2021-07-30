package com.atguigu.java;

import org.junit.Test;

import java.io.*;
import java.util.Objects;

/**
 * 一、流的分类
 *   1.操作数据单位：字节流、字符流
 *   2.数据流向：输入流、输出流
 *   3.角色：节点流、处理流
 *
 * 二、流的体系结构
 *   抽象基类               节点流                 缓冲流
 *   InputStream        FileInputStream      BufferedInputStream
 *   OutputStream       FileOutputStream     BufferedOutputStream
 *   Reader             FileReader           BufferedReader
 *   Writer             FileWriter           BufferedWriter
 *
 * @author Meiko
 * @date 2021-07-30
 */
public class FileReaderWriterTest {

    @Test
    public void test1() {
        File file = new File("hello.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            int data;
            while((data = fr.read()) != -1) {
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(fr)) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        File file = new File("hello.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1) {
                //方式一
    //            for (int i = 0; i < len; i++) {
    //                System.out.print(cbuf[i]);
    //            }

                //方式二
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(fr)) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        File file = new File("hello1.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);

            fw.write("I have a dream!" + "\n");
            fw.write("You need to have a dream!" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(fw)) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test4() {
        File srcFile = new File("hello.txt");
        File destFile = new File("hello2.txt");

        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            int len;
            char[] cbuf = new char[5];
            while((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(fw)) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (Objects.nonNull(fr)) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
