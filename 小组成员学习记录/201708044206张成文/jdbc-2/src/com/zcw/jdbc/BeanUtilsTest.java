package com.zcw.jdbc;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

public class BeanUtilsTest {
	@Test
	public void testGetProperty() throws Exception, InvocationTargetException
	{
		
        Object object = new Customer();
		
		BeanUtils.setProperty(object,"name","JJ");
		System.out.println(object);
		
		Object  val = BeanUtils.getProperty(object, "name");
		System.out.println(val);
		
	}
	
	@Test
	public void testSetProperty() throws Exception, InvocationTargetException
	{
		Object object = new Customer();
		
		BeanUtils.setProperty(object,"name","JJ");
		System.out.println(object);
		
	}

}
