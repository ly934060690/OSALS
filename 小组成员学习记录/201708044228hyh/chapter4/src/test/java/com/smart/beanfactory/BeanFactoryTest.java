package com.smart.beanfactory;

import com.smart.reflect.Car;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.testng.annotations.Test;

import java.io.IOException;

public class BeanFactoryTest {

    @Test
    public void getBean() throws IOException {
        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        Resource res=resolver.getResource("classpath:beans.xml");
        System.out.println(res.getURL());

        //通过XmlBeanDefinitionReader,DefaultListableBeanFactory实现类启动Spring IoC容器
        DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);

        System.out.println("init BeanFactory.");

        Car car=factory.getBean("car1",Car.class);
        System.out.println("car bean is ready for use!");
        car.introduce();
    }
}
