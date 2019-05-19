package edu.zut.cs.software.OSALS.Temporary_station.dao;

import edu.zut.cs.software.OSALS.Temporary_station.domain.Temporary_station;
import edu.zut.cs.software.base.dao.GenericDao;
import org.springframework.stereotype.Repository;

@Repository("temporary_stationDao")
public interface Temporary_stationDao extends GenericDao<Temporary_station, Long> {
}
