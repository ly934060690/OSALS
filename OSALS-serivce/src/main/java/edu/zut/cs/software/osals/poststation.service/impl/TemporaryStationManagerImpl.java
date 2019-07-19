package edu.zut.cs.software.osals.poststation.service.impl;


import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.poststation.dao.TemporaryStationDao;
import edu.zut.cs.software.osals.poststation.domain.TemporaryStation;
import edu.zut.cs.software.osals.poststation.service.TemporaryStationManager;
import edu.zut.cs.software.osals.shop.domain.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class TemporaryStationManagerImpl extends GenericManagerImpl<TemporaryStation, Long> implements TemporaryStationManager {
    TemporaryStationDao temporaryStationDao;

    @Override
    public TemporaryStation findbyTemporaryStationname(String temporarystationname) {
        // TODO Auto-generated method stub
        return null;
    }

    @Autowired
    public void setTemporaryStationDao(TemporaryStationDao temporaryStationDao) {
        this.temporaryStationDao = temporaryStationDao;
        this.dao = this.temporaryStationDao;
    }
}
