package edu.zut.cs.software.osals.expresscar.service;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.expresscar.domain.Enwrap;
import edu.zut.cs.software.osals.expresscar.domain.ExpressCar;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: hyh
 * @Description: EnwrapManager Test Case
 * @Date:Created in 17:06 2019/5/17
 * @Modified By:
 */
public class EnwrapManagerTestCase extends GenericManagerTestCase<Long, Enwrap, EnwrapManager> {

    EnwrapManager enwrapManager;

    public EnwrapManagerTestCase() {
        super(Enwrap.class);
    }

    @Autowired
    public void setEnwrapManager(EnwrapManager enwrapManager) {
        this.enwrapManager = enwrapManager;
        this.manager = this.enwrapManager;
    }

    @Test
    public void testSave(){
        Enwrap enwrap = new Enwrap();
        this.enwrapManager.save(enwrap);
    }

    @Test
    public void testMatchWithName(){
        List<Enwrap> list=this.manager.matchWithName("name");
        if (logger.isInfoEnabled()) {
            logger.info("testMatchWithName() - List<Enwrap> list=={}", list); //$NON-NLS-1$
        }
    }

    @Test
    public void testFindExpressCarByName(){
        List<ExpressCar> list=this.manager.findExpressCarByName("name");
        if (logger.isInfoEnabled()) {
            logger.info("testFindExpressCarByName() - List<ExpressCar> list=={}", list); //$NON-NLS-1$
        }
    }

}
