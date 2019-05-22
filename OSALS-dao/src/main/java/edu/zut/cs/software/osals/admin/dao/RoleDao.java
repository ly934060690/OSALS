package edu.zut.cs.software.osals.admin.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.osals.admin.domain.Role;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public interface RoleDao extends GenericDao<Role, Long> {

}
