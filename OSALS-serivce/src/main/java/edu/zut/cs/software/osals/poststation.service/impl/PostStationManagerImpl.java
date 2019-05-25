package edu.zut.cs.software.osals.poststation.service.impl;

import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.osals.poststation.dao.PostStationDao;
import edu.zut.cs.software.osals.poststation.domain.PostStation;
import edu.zut.cs.software.osals.poststation.service.PostStationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public PostStation findByIdnumber(String idnumber) {
        List<PostStation> postStations = this.postStationDao.findAll();   //getRoot与findAll读取的是什么？实现方式？
        for(PostStation postStation:postStations){
            if(idnumber.equals(postStation.getIdnumber())) {
                return postStation;
            }
        }
        return null;
    }

    @Override
    public PostStation findByName(String entityname) {
        return null;
    }
}
