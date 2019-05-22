package edu.zut.cs.software.osals.temporaryStation.service.impl;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.shop.domain.Commodity;
import edu.zut.cs.software.osals.temporaryStation.dao.TemporaryStationDao;
import edu.zut.cs.software.osals.temporaryStation.domain.TemporaryStation;
import edu.zut.cs.software.osals.temporaryStation.service.TemporaryStationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class TemporaryStationManagerImpl extends GenericManagerImpl<TemporaryStation, Long> implements TemporaryStationManager {
    TemporaryStationDao temporaryStationDao;

    @Override
    public Commodity findbyTemporaryStationname(String temporarystationname) {
        // TODO Auto-generated method stub
        return null;
    }

    @Autowired
    public void setTemporaryStationDao(TemporaryStationDao temporaryStationDao) {
        this.temporaryStationDao = temporaryStationDao;
        this.dao = this.temporaryStationDao;
    }
}
