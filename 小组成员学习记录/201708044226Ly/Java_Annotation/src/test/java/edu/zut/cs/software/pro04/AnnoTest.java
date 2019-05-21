package edu.zut.cs.software.pro04;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnoTest {
    public static void main(String[] args) throws ClassNotFoundException{
        process("edu.zut.cs.software.pro04.Person");
    }

    private static void process(String string) {
        int passed = 0, failed = 0;
        try {
            for(Method method : Class.forName(string).getMethods()) {
                //遍历string所对应类的所有方法
                if(method.isAnnotationPresent(CustomAnno.class)) {
                    //如果该方法使用了自定义注解 @CustomAnno 修饰
                    try {
                        method.invoke(null);
                        passed++;
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("方法 " + method + " 测试失败，出现异常");
                        failed++;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("一共运行了 " + (passed + failed) + " 个方法");
        System.out.println("成功运行方法 " + passed + " 个");
        System.out.println("失败运行方法 " + failed + " 个");
    }
}
