package com.smart.resourceexample;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.testng.annotations.*;

import java.io.IOException;

import static org.testng.Assert.*;

public class PatternResolverTest {
    @Test
    public void getResolverTest() throws IOException {
        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();

        Resource resources[]=resolver.getResources("classpath*:com.smart/**/");

        assertNotNull(resources);
        for(Resource resource:resources){
            System.out.println(resource.getDescription());
        }
    }
}
