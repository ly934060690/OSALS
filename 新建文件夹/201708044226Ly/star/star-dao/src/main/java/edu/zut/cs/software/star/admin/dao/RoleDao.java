package edu.zut.cs.software.star.admin.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.star.admin.domain.Role;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public interface RoleDao extends GenericDao<Role, Long> {

}
