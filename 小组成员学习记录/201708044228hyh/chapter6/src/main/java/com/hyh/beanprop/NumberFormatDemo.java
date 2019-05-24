package com.hyh.beanprop;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @Author: hyh
 * @Description: locale是创建国际化应用的基础 NumberFormat,DateFormat,MessageFormat格式化操作工具类
 * @Date:Created in 15:44 2019/5/18
 * @Modified By:
 */
public class NumberFormatDemo {

    public static void main(String[] args) {

        Locale locale=new Locale("zh","CN");

        //numberFormat按本地化方式对货币进行格式化操作
        NumberFormat currFmt=NumberFormat.getCurrencyInstance(locale);
        double amt=123456.78;
        System.out.println(currFmt.format(amt));

        Locale locale1=new Locale("en","US");

        Date date=new Date();
        DateFormat df=DateFormat.getDateInstance(DateFormat.MEDIUM,locale);
        System.out.println(df.format(date));

        //格式化信息串
        String pattern1="{0},您好！你于{1}在工商银行存入{2}元";
        String pattern2="At {1,time,short} on {1,date,long},{0} paid {2,number,currrency}";

        //用于动态替换占位符的参数
        Object[] params={"John",new GregorianCalendar().getTime(),1.0E3};

        //使用默认本地化对象格式化信息
        String msg1= MessageFormat.format(pattern1,params);

        MessageFormat mf=new MessageFormat(pattern2,Locale.US);
        String msg2=mf.format(params);
        System.out.println(msg1);
        System.out.println(msg2);
    }
}
