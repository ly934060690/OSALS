package edu.zut.cs.software.osals.temporaryStation.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.shop.domain.Commodity;
import edu.zut.cs.software.osals.temporaryStation.domain.TemporaryStation;

import java.util.List;

public interface TemporaryStationManager extends GenericManager<TemporaryStation, Long> {
    List<TemporaryStation> findAll();

    Commodity findbyTemporaryStationname(String temporarystationyname);
}
