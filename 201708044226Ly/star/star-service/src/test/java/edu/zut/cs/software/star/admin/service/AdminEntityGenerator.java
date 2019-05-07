package edu.zut.cs.software.star.admin.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.service.GenericGenerator;
import edu.zut.cs.software.star.admin.domain.Group;
import edu.zut.cs.software.star.admin.domain.User;

/**
 * 无事物回滚测试
 * @author 研哥哥
 *
 */
public class AdminEntityGenerator extends GenericGenerator {
	
	
	@Autowired
	RoleManager roleManager;
	@Autowired
	UserManager userManager;
	@Autowired
	GroupManager groupManager;
	
	@Test
	public void gen_group() {
		for(int i = 0; i < 10; i++) {
			Group g = new Group();
			g.setName("group_" + i);
			this.groupManager.save(g);
			for(int j = 0; j < 10; j++) {
				Group group = new Group();
				group.setName("group_" + i + "_" + j);
				group.setParent(g);
				g = this.groupManager.save(group);
				this.gen_user(g);
			}
		}
	}
	
	public void gen_user(Group g) {
		for(int i = 0; i < 10; i++) {
			User u = new User();
			u.setUsername("username_" + i);
			u.setPassword("password_" + i);
			u.setGroup(g);
			this.userManager.save(u);
		}
	}
}
