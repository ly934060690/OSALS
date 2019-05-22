package edu.zut.cs.software.OSALS.admin.dao;

import edu.zut.cs.software.base.dao.GenericTreeDaoTestCase;
import edu.zut.cs.software.OSALS.admin.domain.Group;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * root_size出错
 * @author 研哥哥
 *
 */
public class GroupDaoTest extends GenericTreeDaoTestCase<Long, Group, GroupDao> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(GroupDaoTest.class.getName());

	GroupDao groupDao;
	
	@Autowired
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
		this.dao = this.groupDao;
	}
	
	@Test
	public void testGetRoot() {
		int root_size = 10;
		for(int i = 0; i < root_size; i++) {
			Group group = new Group();
			group.setName("group_" + i);
			for(int j = 0; j < 10; j++) {
				Group g = new Group();
				g.setName("group_" + i + "_" + j);
				g.setParent(group);
			}
			this.groupDao.save(group);
		}
		
		List<Group> roots = this.groupDao.getRoot();
		assertEquals(root_size, roots.size());
		
		if (logger.isInfoEnabled()) {
			logger.info("testGetRoot() - List<Group> roots={}", roots); //$NON-NLS-1$
		}
		
	}
}
