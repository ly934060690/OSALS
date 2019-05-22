package edu.zut.cs.software.OSALS.temporaryStation.dao;

import edu.zut.cs.software.OSALS.temporaryStation.domain.TemporaryStation;
import edu.zut.cs.software.base.dao.GenericDao;
import org.springframework.stereotype.Repository;

@Repository("temporaryStationDao")
public interface TemporaryStationDao extends GenericDao<TemporaryStation, Long> {
}
