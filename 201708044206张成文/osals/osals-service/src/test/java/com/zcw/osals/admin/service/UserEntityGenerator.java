package com.zcw.osals.admin.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zcw.osals.admin.domain.Group;
import com.zcw.osals.admin.domain.User;
import com.zcw.osals.base.service.impl.GenericGenerator;

public class UserEntityGenerator extends GenericGenerator {

	@Autowired
	UserManager userManager;
	@Autowired
	GroupManager groupManager;

	@Test
	public void gen_group() {
		for (int i = 0; i < 10; i++) {
			Group g = new Group();
			g.setName("group_" + i);
			this.groupManager.save(g);
			for (int j = 0; j < 10; j++) {
				Group group = new Group();
				group.setName("group_" + i + "_" + j);
				group.setParent(g);
				g = this.groupManager.save(group);
				this.gen_user(g);
			}
		}
	}

	public void gen_user(Group g) {
		for (int i = 0; i < 10; i++) {
			User u = new User();
			u.setName("username_" + i);
			u.setGroup(g);
			this.userManager.save(u);
		}
	}
}
