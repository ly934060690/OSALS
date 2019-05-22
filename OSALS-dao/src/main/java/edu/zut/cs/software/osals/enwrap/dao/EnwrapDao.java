package edu.zut.cs.software.osals.enwrap.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.osals.enwrap.domain.Enwrap;
import org.springframework.stereotype.Repository;

/**
 * @Author: hyh
 * @Description: EnwrapDao
 * @Date:Created in 19:23 2019/5/16
 * @Modified By:
 */
@Repository("enwrapDao")
public interface EnwrapDao extends GenericDao<Enwrap, Long> {
}
