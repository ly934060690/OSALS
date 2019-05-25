package edu.zut.cs.software.osals.poststation.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.osals.poststation.domain.TemporaryStation;
import org.springframework.stereotype.Repository;

@Repository("temporaryStationDao")
public interface TemporaryStationDao extends GenericDao<TemporaryStation, Long> {
}
