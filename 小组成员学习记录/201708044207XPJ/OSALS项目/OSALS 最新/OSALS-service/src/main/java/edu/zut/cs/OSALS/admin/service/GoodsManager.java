package edu.zut.cs.OSALS.admin.service;

import edu.zut.cs.OSALS.admin.domain.Goods;
import edu.zut.cs.OSALS.base.service.GenericManager;

import java.util.List;

public interface GoodsManager extends GenericManager<Goods,Long> {

    String sayHello(String name);

    List<Goods> getAll();
}
