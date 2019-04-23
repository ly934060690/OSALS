package edu.zut.cs.network.example.object;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import edu.zut.cs.network.example.base.BaseTestCase;

public class FanTest extends BaseTestCase {

	Fan fan;

	@Test
	public void testFan() {
		this.fan = new Fan();
		this.fan.setId(Long.valueOf(10001));
		this.fan.setColour("Red");
		this.fan.setRadius(1.5);
		this.fan.setSpeed(100);
		logger.debug(this.fan);
		assertNotNull(this.fan);
	}

}
