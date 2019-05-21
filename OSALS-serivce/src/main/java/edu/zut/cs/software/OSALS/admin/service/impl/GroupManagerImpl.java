package edu.zut.cs.software.OSALS.admin.service.impl;

import edu.zut.cs.software.OSALS.admin.dao.GroupDao;
import edu.zut.cs.software.OSALS.admin.domain.Group;
import edu.zut.cs.software.OSALS.admin.service.GroupManager;
import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 待注解
 * @author 研哥哥
 *
 */
@Service("groupManager")
@Transactional
public class GroupManagerImpl extends GenericTreeManagerImpl<Group, Long> implements GroupManager {

	GroupDao groupDao;

	@Autowired
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
		this.treeDao = this.groupDao;
		this.dao = this.treeDao;
	}
	
	
}
