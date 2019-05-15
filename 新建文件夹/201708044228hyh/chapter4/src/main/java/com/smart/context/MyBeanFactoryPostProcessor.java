package com.smart.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @Author:
 * @Description: 工厂后处理器实例
 * @Date:Created in 19:11 2019/4/25
 * @Modified By:
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
    *@Author:
    *@Description: 对car<bean>的brand属性配置信息进行“偷梁换柱”的加工操作
    *@Date: 19:12 2019/4/25
    */
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("car");

        bd.getPropertyValues().addPropertyValue("brand", "奇瑞QQ");
        System.out.println("调用BeanFactoryPostProcessor.postProcessBeanFactory()!");
    }
}
