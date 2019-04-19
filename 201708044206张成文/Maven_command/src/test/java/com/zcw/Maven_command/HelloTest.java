package com.zcw.Maven_command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloTest {

	
	@Test
	public void testHello()
	{
		Hello hello = new Hello();
		String results = hello.sayHello("en");
		assertEquals("Hello en",results);
	}
}
