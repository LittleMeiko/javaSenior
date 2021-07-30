package com.atguigu.java;

import org.junit.Test;

import java.io.*;
import java.util.Objects;

/**
 *
 *
 * @author Meiko
 * @date 2021-07-30
 */
public class FileInputOutputStreamTest {

    @Test
    public void test1() {
        File file = new File("hello.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            int len;
            byte[] data = new byte[5];
            while ((len = fis.read(data)) != -1) {
                String str = new String(data,0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(fis)) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        File srcFile = new File("上证指数.jpg");
        File destFile = new File("20210730上证指数.jpg");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            int len;
            byte[] buffer = new byte[5];
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer,0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(fos)) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(fis)) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
