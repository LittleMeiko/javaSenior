package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;

/**
 * RandomAccessFile的使用：
 * 1.直接继承于Object.lang.Object,实现了DataInput和DataOutput接口
 * 2.既可以作为输入流也可以作为输出流
 *
 *
 */
public class RandomAccessFileTest {

    @Test
    public void test3() throws IOException {
        File file = new File("hello.txt");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(3);
        byte[] buf = new byte[20];
        int len;
        StringBuilder sb = new StringBuilder((int) file.length());
        while((len = raf.read(buf)) != -1) {
            sb.append(new String(buf, 0, len));
        }

        raf.seek(3);
        raf.write("xyz".getBytes());
        raf.write(sb.toString().getBytes());

        raf.close();
    }

    @Test
    public void test2() throws IOException {
        File file = new File("hello.txt");
        RandomAccessFile raf1 = new RandomAccessFile(file, "rw");
        raf1.seek(file.length());
        raf1.write("xyz".getBytes());
        raf1.close();
    }

    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("上证指数.jpg"), "r");
            raf2 = new RandomAccessFile(new File("上证指数2.jpg"), "rw");

            byte[] buf = new byte[1024];
            int len;
            while((len = raf1.read(buf)) != -1) {
                raf2.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(raf1)) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(raf2)) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
