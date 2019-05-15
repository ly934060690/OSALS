package edu.zut.cs.software.star.admin.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.star.admin.domain.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao extends GenericDao<User, Long>{

}
