package edu.zut.cs.software.osals.postStation.service.impl;

import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.osals.postStation.dao.PostStationDao;
import edu.zut.cs.software.osals.postStation.domain.PostStation;
import edu.zut.cs.software.osals.postStation.service.PostStationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("postStationManager")
@Transactional
public class PostStationManagerImpl extends GenericTreeManagerImpl<PostStation, Long> implements PostStationManager {
    PostStationDao postStationDao;

    @Autowired
    public void setShopDao(PostStationDao postStationDao) {
        this.postStationDao = postStationDao;
        this.treeDao = this.postStationDao;
        this.dao = this.treeDao;
    }
}
