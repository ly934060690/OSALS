package edu.zut.cs.software.osals.postStation.dao;

import edu.zut.cs.software.base.dao.GenericTreeDao;
import edu.zut.cs.software.osals.postStation.domain.PostStation;
import org.springframework.stereotype.Repository;

@Repository("postStationDao")
public interface PostStationDao extends GenericTreeDao<PostStation, Long> {
}
