package edu.zut.cs.software.OSALS.admin.dao;

import edu.zut.cs.software.OSALS.admin.domain.Group;
import edu.zut.cs.software.base.dao.GenericTreeDao;
import org.springframework.stereotype.Repository;

@Repository("groupDao")
public interface GroupDao extends GenericTreeDao<Group, Long> {

}
