package edu.zut.cs.software.OSALS.temporaryStation.service;

import edu.zut.cs.software.OSALS.commodity.domain.Commodity;
import edu.zut.cs.software.OSALS.temporaryStation.domain.TemporaryStation;
import edu.zut.cs.software.base.service.GenericManager;

import java.util.List;

public interface TemporaryStationManager extends GenericManager<TemporaryStation, Long> {
    List<TemporaryStation> findAll();

    Commodity findbyTemporaryStationname(String temporarystationyname);
}
