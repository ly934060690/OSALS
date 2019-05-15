package com.smart;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

// -1 管理Bean生命周期的接口
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car(){
        System.out.println("调用Car()构造函数。");
    }


    public void setBrand(String brand) {
        System.out.println("调用setBrand()设置属性。");
        this.brand = brand;
    }

    public void introduce(){
        System.out.println("brand:"+brand+"; color:"+color+"; maxSpeed:"+maxSpeed);
    }

    // -2 BeanFactoryAware接口方法
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory().");
        this.beanFactory=beanFactory;
    }

    // -3 调用BeanNameAware接口方法
    public void setBeanName(String beanName) {
        System.out.println("调用BeanNameAware.setBeanName().");
        this.beanName=beanName;
    }

    // -4 DisposableBean接口方法
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destroy().");
    }

    // -5 InitializingBean接口方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet().");
    }

    // -6 通过<bean>的init-method属性指定的初始化方法
    public void myInit(){
        System.out.println("调用init-method所指定的myInit(),将maxSpeed设置为240.");
        this.maxSpeed=240;
    }

    // -7 通过<bean>的destroy-method属性指定销毁方法
    public void myDestroy(){
        System.out.println("调用destroy-method所指定的myDestroy().");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
