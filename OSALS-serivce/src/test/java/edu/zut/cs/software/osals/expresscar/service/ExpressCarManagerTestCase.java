package edu.zut.cs.software.osals.expresscar.service;

import edu.zut.cs.software.base.service.GenericTreeManagerTestCase;
import edu.zut.cs.software.osals.expresscar.domain.Enwrap;
import edu.zut.cs.software.osals.expresscar.domain.ExpressCar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * @Author: hyh
 * @Description: ExpressCarManager Test Case
 * @Date:Created in 16:55 2019/5/17
 * @Modified By:
 */
public class ExpressCarManagerTestCase  extends GenericTreeManagerTestCase<Long, ExpressCar, ExpressCarManager> {

    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(ExpressCarManagerTestCase.class.getName());

    ExpressCarManager expressCarManager;

    public ExpressCarManagerTestCase() {
        super(ExpressCar.class);
    }

    @Autowired
    public void setExpressCarManager(ExpressCarManager expressCarManager) {
        this.expressCarManager = expressCarManager;
        this.manager = this.expressCarManager;
    }

    @Test
    public void testFindAll() {
        List<ExpressCar> result = this.expressCarManager.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Shop> result={}", result); //$NON-NLS-1$
        }
    }

    @Test
    public void testMatchWithName(){
        List<ExpressCar> expressCars=this.manager.matchWithName("name");
        if (logger.isInfoEnabled()) {
            logger.info("testMatchWithName() -  List<ExpressCar> expressCars={}", expressCars); //$NON-NLS-1$
        }
    }

    @Test
    public void testFindEnwrapsByName(){
        List<Set<Enwrap>> list=this.manager.findEnwrapsByName("name");
        if (logger.isInfoEnabled()) {
            logger.info(" testFindEnwrapsByName() -  List<Set<Enwrap>> list={}", list); //$NON-NLS-1$
        }
    }
}
