package com.zcw.osals.group.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zcw.osals.admin.domain.Group;
import com.zcw.osals.admin.domain.User;
import com.zcw.osals.admin.service.GroupManager;
import com.zcw.osals.admin.service.UserManager;
import com.zcw.osals.base.service.impl.GenericGenerator;

public class GroupEntityGenerator extends GenericGenerator {

	@Autowired
	UserManager userManager;
	@Autowired
	GroupManager groupManager;

	@Test
	public void gen_group() {
		for (int i = 0; i < 10; i++) {
			Group group = new Group();
			group.setName("group_" + i);
			this.groupManager.save(group);
			for (int j = 0; j < 10; j++) {
				Group group2 = new Group();
				group2.setName("group_" + i + "_" + j);
				group2.setParent(group);
				group = this.groupManager.save(group2);
				this.gen_user(group);
			}
		}
	}

	public void gen_user(Group group) {

		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setEntityName("user_" + i);
			user.setGroup(group);
			this.userManager.save(user);
		}
	}

}
