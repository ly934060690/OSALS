package edu.zut.cs.software.OSALS.postStation.dao;

import edu.zut.cs.software.OSALS.postStation.domain.PostStation;
import edu.zut.cs.software.base.dao.GenericTreeDao;
import org.springframework.stereotype.Repository;

@Repository("postStationDao")
public interface PostStationDao extends GenericTreeDao<PostStation, Long> {
}
