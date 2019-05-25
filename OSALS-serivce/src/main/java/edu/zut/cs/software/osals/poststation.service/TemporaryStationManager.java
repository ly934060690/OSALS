package edu.zut.cs.software.osals.poststation.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.poststation.domain.TemporaryStation;
import edu.zut.cs.software.osals.shop.domain.Commodity;

import java.util.List;

public interface TemporaryStationManager extends GenericManager<TemporaryStation, Long> {
    List<TemporaryStation> findAll();

    TemporaryStation findbyTemporaryStationname(String temporarystationyname);
}
