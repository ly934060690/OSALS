package com.zut.zcw.test;

import java.util.ArrayList;
import java.util.List;

import com.zut.zcw.beans.Teacher;
import com.zut.zcw.util.BeanDefined;
import com.zut.zcw.util.BeanFactory;

public class TeatMain {
	public static void main(String[] args) throws Exception
	{
		
		//1.声明注册bean
		BeanDefined beanObj = new BeanDefined();
		beanObj.setBeanId("teacher");
		beanObj.setClassPath("com.zut.zcw.beans.Teacher");
		
		
		List beanList = new ArrayList();
		beanList.add(beanObj);//spring 核心配置
		
		
		//2.声明一个spring提供的BeanFacotory
		BeanFactory factory = new BeanFactory();
		factory.setBeanDefinedList(beanList);
		
		//3.开发人员向BeanFactory索要实例对象
		
		Teacher t=  (Teacher) factory.getBean("teacher");
		System.out.println(t);
	}

}
