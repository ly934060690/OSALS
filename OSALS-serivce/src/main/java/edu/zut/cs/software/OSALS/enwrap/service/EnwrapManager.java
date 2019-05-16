package edu.zut.cs.software.OSALS.enwrap.service;

import edu.zut.cs.software.OSALS.enwrap.domain.Enwrap;
import edu.zut.cs.software.OSALS.expresscar.domain.ExpressCar;
import edu.zut.cs.software.base.service.GenericManager;

import java.util.List;

/**
 * @Author: hyh
 * @Description:
 * @Date:Created in 21:12 2019/5/16
 * @Modified By:
 */
public interface EnwrapManager extends GenericManager<Enwrap, Long> {//和这个保持

    List<Enwrap> findAll();

    Enwrap findbyEnwrapName(String enwrapname);

}
