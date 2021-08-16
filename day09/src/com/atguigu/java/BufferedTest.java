package com.atguigu.java;

import org.junit.Test;

import java.io.*;
import java.util.Objects;

/**
 * 处理流之一：缓冲流的使用
 * 作用：提高流的读取和写入速度
 *
 */
public class BufferedTest {

    @Test
    public void bufferedReaderTest() {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(new File("note.txt")));
            bw = new BufferedWriter(new FileWriter(new File("note2.txt")));

            String data;
            while ((data = br.readLine()) != null) {
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(br)) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(bw)) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 非文本文件的复制
     */
    @Test
    public void bufferedStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("上证指数.jpg");
            File destFile = new File("上证指数2.jpg");

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            int len;
            byte[] buffer = new byte[10];
            while((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(bis)) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(bos)) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
