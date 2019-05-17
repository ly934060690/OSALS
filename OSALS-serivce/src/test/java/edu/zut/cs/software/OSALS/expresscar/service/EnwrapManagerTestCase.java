package edu.zut.cs.software.OSALS.expresscar.service;

import edu.zut.cs.software.OSALS.enwrap.domain.Enwrap;
import edu.zut.cs.software.OSALS.enwrap.service.EnwrapManager;
import edu.zut.cs.software.base.service.GenericManagerTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: hyh
 * @Description:
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
}
