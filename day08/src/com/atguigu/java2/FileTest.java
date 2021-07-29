package com.atguigu.java2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * IO流-File类的使用
 *
 * @author Meiko
 * @date 2021-07-29
 */
public class FileTest {

    @Test
    public void test1() {
        //构造器1:相对路径
        File file = new File("hello.txt");
        //绝对路径
        File file1 = new File("D:\\git_workspace\\javaSenior\\day08\\hello.txt");
        System.out.println(file);
        System.out.println(file1);

        //构造器2
        File file2 = new File("D:\\git_workspace\\javaSenior\\", "day08");
        System.out.println(file2);

        //构造器3
        File file3 = new File(file2, "hello.txt");
        System.out.println(file3);
    }

    @Test
    public void test2() {
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.getName());
        System.out.println(file.length());
        System.out.println(file.lastModified());
    }

    @Test
    public void test3() {
        File file = new File("D:\\git_workspace\\javaSenior");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println();

        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }
    }

    @Test
    public void test4() {
        File file = new File("hello.txt");
        File dest = new File("D:\\git_workspace\\javaSenior\\hi.txt");
        boolean b = file.renameTo(dest);
        System.out.println(b);
    }

    @Test
    public void test5() throws IOException {
        File file = new File("hello.txt");
        if (!file.exists()) {
            boolean newFile = file.createNewFile();
            System.out.println(newFile);
        } else {
            file.delete();
            System.out.println("删除成功");
        }
    }
}
