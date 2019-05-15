package com.smart.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
   /**
   *@Author:
   *@Description:-1 接口方法，在实例化Bean前调用
   *@Date: 16:44 2019/4/25
   */
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName){
        // -1 仅对容器中的car Bean处理
        if("car".equals(beanName)){
            System.out.println("InstantiationAware BeanPostProcessor.postProcessBeforeInstantiation");
        }
        return null;
    }
    
    /**
    *@Author:
    *@Description:-2 接口方法，在实例化Bean后调用
    *@Date: 16:52 2019/4/25
    */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName){
        if("car".equals(beanName)){
            System.out.println("InstantiationAware BeanPostProcessor.postProcessAfterInstantiation");
        }
        return true;
    }

    /**
     *@Author:
     *@Description:-3 接口方法，在设置某个属性时调用
     *@Date: 16:54 2019/4/25
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)){
            System.out.println("Instantiation AwareBeanPostProcessor.postProcessPropertyValue");
        }
        return pvs;
    }
}
