package com.cybertek.tests.Day10_FileUpload;

import org.testng.annotations.Test;

public class FilePathExample {
    @Test
    public void test(){

        System.out.println(System.getProperty("user.dir")); // user.dir = user directory : folder!!
        String projectPath = System.getProperty("user.dir");
        String relativePath ="/src/verifyContactInfoTest/Resources/testFile.txt";

        String filePath = projectPath+"/"+relativePath;
        System.out.println(filePath);

        }
}
