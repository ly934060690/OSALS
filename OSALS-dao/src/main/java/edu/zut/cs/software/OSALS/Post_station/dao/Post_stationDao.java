package edu.zut.cs.software.OSALS.Post_station.dao;

import edu.zut.cs.software.OSALS.Post_station.domain.Post_station;
import edu.zut.cs.software.base.dao.GenericTreeDao;
import org.springframework.stereotype.Repository;

@Repository("post_stationDao")
public interface Post_stationDao extends GenericTreeDao<Post_station, Long> {
}
