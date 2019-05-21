package com.smart.resourceexample;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileSourceExample {

    public static void main(String[] args) throws IOException {
        String filePath="D:\\Java\\workspace\\Idea-projects\\chapter4\\src\\main\\resources\\conf\\file1.txt";

        // -1 使用系统文件路径的方式加载文件
        WritableResource res1=new PathResource(filePath);

        // -2 以类路径的方式加载文件
        Resource res2=new ClassPathResource("conf/file1.txt");

        // -3 使用WritableResource接口写文件
        OutputStream stream1=res1.getOutputStream();
        stream1.write("这是一个资源抽象接口的测试！".getBytes());
        stream1.close();

        // -4 使用Resource接口读资源文件
        InputStream ins1=res1.getInputStream();
        InputStream ins2=res2.getInputStream();

        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        int i;
        while((i=ins1.read())!=-1){
            baos.write(i);
        }
        System.out.println(baos.toString());

        System.out.println("res1:"+res1.getFilename());
        System.out.println("res2:"+res2.getFilename());
    }
}
