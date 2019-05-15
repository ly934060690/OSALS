package com.zcw.osals.group.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.zcw.osals.admin.domain.Group;
import com.zcw.osals.admin.service.GroupManager;
import com.zcw.osals.base.service.impl.GenericManagerTestCase;

@ContextConfiguration(locations = { "classpath:applicationContext-service.xml" })
public class GroupManagerTest extends GenericManagerTestCase<Long, Group, GroupManager> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(GroupManagerTest.class.getName());

	GroupManager groupManager;

	public GroupManagerTest() {
		super(Group.class);
	}

	@Autowired
	public void setGroupManager(GroupManager groupManager) {
		this.groupManager = groupManager;
		this.manager = this.groupManager;
	}

	@Test
	public void testSave() {
		logger.debug("This is a test method for AOP");
		List<Group> groupList = new ArrayList<Group>();
		for (int i = 0; i < 10; i++) {
			Group group = new Group();
			groupList.add(group);

		}
		this.groupManager.save(groupList);
	}

}
