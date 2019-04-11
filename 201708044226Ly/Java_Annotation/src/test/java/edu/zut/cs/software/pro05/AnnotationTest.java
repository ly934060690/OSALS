package edu.zut.cs.software.pro05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationTest {
    public static void main(String[] args) {
        resolveClassAnnotationInfo(AnnotationDemo.class);
        resolveFieldAnnotationInfo(AnnotationDemo.class);
        resolveMethodAnnotationInfo(AnnotationDemo.class);
    }

    private static void resolveClassAnnotationInfo(Class<?> clz) {
        //判断该类是否含有ClassInfo注解
        if(clz.isAnnotationPresent(ClassInfo.class)) {
            ClassInfo classInfo = clz.getAnnotation(ClassInfo.class);
            System.out.println(classInfo.author() + " " + classInfo.date() + " " + classInfo.comments());
        }
    }

    private static void resolveFieldAnnotationInfo(Class<?> clz) {
        Field[] fields = clz.getDeclaredFields();
        for(Field field : fields) {
            if(field.isAnnotationPresent(FieldInfo.class)) {
                FieldInfo fieldInfo = field.getAnnotation(FieldInfo.class);
                System.out.println(fieldInfo.name() + " " + fieldInfo.type() );
            }
        }
    }

    private static void resolveMethodAnnotationInfo(Class<?> clz) {
        Method[] methods = clz.getDeclaredMethods();
        for(Method method : methods) {
            if(method.isAnnotationPresent(MethodInfo.class)) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                System.out.println(methodInfo.name() + " " + methodInfo.description());
            }
        }
    }


}
