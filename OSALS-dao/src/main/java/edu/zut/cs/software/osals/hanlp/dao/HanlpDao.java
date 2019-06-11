package edu.zut.cs.software.osals.hanlp.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.osals.hanlp.domain.Hanlp;
import org.springframework.stereotype.Repository;

@Repository("hanlpDao")
public interface HanlpDao extends GenericDao<Hanlp, Long> {

}
