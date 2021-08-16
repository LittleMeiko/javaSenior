package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 其它流的使用：
 * 1.标准的输入、输出流
 * 2.打印流
 * 3.数据流：用于读取、写入内存中的基本数据类型或者字符串
 *
 */
public class OtherStreamTest {

    @Test
    public void test4() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        String name = dis.readUTF();
        int age = dis.readInt();
        boolean isMale = dis.readBoolean();

        System.out.println("name=" + name);
        System.out.println("age=" + age);
        System.out.println("isMale=" + isMale);
    }

    @Test
    public void test3() throws IOException {
        FileOutputStream fos = new FileOutputStream("data.txt");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeUTF("马龙");
        dos.flush();
        dos.writeInt(32);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();

        dos.close();
    }

    @Test
    public void test2() throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("output.txt");
        PrintStream ps = new PrintStream(fos, true);
        System.setOut(ps);

        for (int i = 0; i < 255; i++) {
            System.out.print((char)i);
            if (i % 50 == 0) {
                System.out.println();
            }
        }

        ps.close();
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            System.out.println("请输入一个字符串：");
            String line = br.readLine();
            if ("e".equalsIgnoreCase(line) || "exit".equalsIgnoreCase(line)) {
                System.out.println("程序退出");
                break;
            }
            String toUpperCase = line.toUpperCase();
            System.out.println(toUpperCase);
        }

        br.close();
    }
}
