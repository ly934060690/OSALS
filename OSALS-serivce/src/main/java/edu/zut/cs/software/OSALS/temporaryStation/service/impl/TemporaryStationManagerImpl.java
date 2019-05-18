package edu.zut.cs.software.OSALS.temporaryStation.service.impl;

import edu.zut.cs.software.OSALS.commodity.domain.Commodity;
import edu.zut.cs.software.OSALS.temporaryStation.dao.TemporaryStationDao;
import edu.zut.cs.software.OSALS.temporaryStation.domain.TemporaryStation;
import edu.zut.cs.software.OSALS.temporaryStation.service.TemporaryStationManager;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
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
