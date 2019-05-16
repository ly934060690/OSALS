package edu.zut.cs.software.OSALS.expresscar.service.impl;

import edu.zut.cs.software.OSALS.expresscar.dao.ExpressCarDao;
import edu.zut.cs.software.OSALS.expresscar.domain.ExpressCar;
import edu.zut.cs.software.OSALS.expresscar.service.ExpressCarManager;
import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Author: hyh
 * @Description:
 * @Date:Created in 21:05 2019/5/16
 * @Modified By:
 */
@Service("expressCarManager")
@Transactional
public class ExpressCarManagerImpl extends GenericTreeManagerImpl<ExpressCar, Long> implements ExpressCarManager {

    ExpressCarDao expressCarDao;

    @Autowired
    public void setShopDao(ExpressCarDao expressCarDao) {
        this.expressCarDao = expressCarDao;
        this.treeDao = this.expressCarDao;
        this.dao = this.treeDao;
    }

}

