package edu.zut.cs.software.OSALS.admin.dao;

import edu.zut.cs.software.OSALS.admin.domain.Role;
import edu.zut.cs.software.base.dao.GenericDao;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public interface RoleDao extends GenericDao<Role, Long> {

}
