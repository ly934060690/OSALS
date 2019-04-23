package edu.zut.cs.network.example.collection;

import org.junit.Before;
import org.junit.Test;

public class SetExampleTest {

	SetExample example;

	@Before
	public void before() {
		this.example = new SetExample();
	}

	@Test
	public void test() {
		this.example.doExample();
	}

}
