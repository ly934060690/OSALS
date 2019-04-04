package com.zut.zcw.util;

import java.util.List;

public class BeanFactory {

	private List<BeanDefined> beanDefinedList;

	public List<BeanDefined> getBeanDefinedList() {
		return beanDefinedList;
	}

	public void setBeanDefinedList(List<BeanDefined> beanDefinedList) {
		this.beanDefinedList = beanDefinedList;
	}
	public Object getBean(String beanId) throws Exception
	{
		Object instance;
		for(BeanDefined beanObj:beanDefinedList)//能够限定getBean得到的bendId是beanDefinedList中的
		{
			if(beanId.equals(beanObj.getBeanId()))
			{
				String classPath = beanObj.getClassPath();
				Class classFile = Class.forName(classPath);
				//在默认情况下，spring工厂通过调用当前雷的默认构造方法创建实例对象
				instance = classFile.newInstance();
				return instance;
			}
		}
		return null;
	}
}
