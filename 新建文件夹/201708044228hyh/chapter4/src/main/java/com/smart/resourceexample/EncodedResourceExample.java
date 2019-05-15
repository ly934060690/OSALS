package com.smart.resourceexample;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

public class EncodedResourceExample {

    public static void main(String[] args) throws IOException {
        Resource res=new ClassPathResource("conf/file1.txt");
        EncodedResource enRes=new EncodedResource(res,"UTF-8");
        String content= FileCopyUtils.copyToString(enRes.getReader());
        System.out.println(content);
    }
}
