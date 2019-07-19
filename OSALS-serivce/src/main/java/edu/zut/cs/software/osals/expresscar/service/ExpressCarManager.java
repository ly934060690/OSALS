package edu.zut.cs.software.osals.expresscar.service;

import edu.zut.cs.software.base.service.GenericTreeManager;
import edu.zut.cs.software.osals.expresscar.domain.Enwrap;
import edu.zut.cs.software.osals.expresscar.domain.ExpressCar;

import java.util.List;
import java.util.Set;

/**
 * @Author: hyh
 * @Description: ExpressCar Manager
 * @Date:Created in 21:05 2019/5/16
 * @Modified By:
 */
public interface ExpressCarManager extends GenericTreeManager<ExpressCar, Long> {

    List<ExpressCar> matchWithName(String name);

    List<Set<Enwrap>> findEnwrapsByName(String name);

}
