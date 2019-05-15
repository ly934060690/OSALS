package edu.zut.cs.software.OSALS.admin.dao;

import edu.zut.cs.software.OSALS.admin.domain.User;
import edu.zut.cs.software.base.dao.GenericDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao extends GenericDao<User, Long> {

}
