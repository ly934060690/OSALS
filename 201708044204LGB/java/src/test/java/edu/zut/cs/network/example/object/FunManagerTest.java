package edu.zut.cs.network.example.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.zut.cs.network.example.base.BaseTestCase;

public class FunManagerTest extends BaseTestCase {

	FanManager fanManager;

	@Before
	public void before() {
		this.fanManager = new FanManagerImpl();
	}

	@Test
	public void testGetAll() {
		List<Fan> result = this.fanManager.getAll();
		assertEquals(100, result.size());
	}

	@Test
	public void testGetById() {
		Long id = Long.valueOf(10);
		Fan result = this.fanManager.getById(id);
		logger.info(result);
		assertNotNull(result);
		assertEquals(id, result.getId());
	}

}
