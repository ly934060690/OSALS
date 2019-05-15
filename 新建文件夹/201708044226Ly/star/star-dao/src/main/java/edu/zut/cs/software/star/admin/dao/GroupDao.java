package edu.zut.cs.software.star.admin.dao;

import edu.zut.cs.software.base.dao.GenericTreeDao;
import edu.zut.cs.software.star.admin.domain.Group;
import org.springframework.stereotype.Repository;

@Repository("groupDao")
public interface GroupDao extends GenericTreeDao<Group, Long> {

}
