package com.jacend.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileTest {

    public static void main(String[] args) throws IOException {
        String path = "/Users/jacend/Code/private/learn_design_code/upgrade-java/src/main/resources/sun.txt";
        // 读取文件
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        // 写入文件
        Files.write(Paths.get(path), "追加内容".getBytes(), StandardOpenOption.APPEND);
    }
}
