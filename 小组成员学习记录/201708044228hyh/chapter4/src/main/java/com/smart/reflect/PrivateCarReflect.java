package com.smart.reflect;

//通过反射机制绕过类实例变量无法在外部访问私有，保护变量和方法

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateCarReflect {
    public static void main(String[] args) throws Throwable {
        ClassLoader loader=Thread.currentThread().getContextClassLoader();
        Class clazz=loader.loadClass("com.smart.reflect.PrivateCar");
        Constructor cons=clazz.getDeclaredConstructor((Class[])null);
        PrivateCar pcar=(PrivateCar) cons.newInstance();
        Field colorFld=clazz.getDeclaredField("color");

        // -1 取消java语言访问检查以访问private变量
        colorFld.setAccessible(true);
        colorFld.set(pcar,"红色");

        Method driveMtd=clazz.getDeclaredMethod("drive",(Class[])null);

        // -2 取消java语言访问检查以访问protected方法
        driveMtd.setAccessible(true);
        driveMtd.invoke(pcar,(Object[])null);
    }
}
