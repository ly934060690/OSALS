package edu.zut.cs.software.osals.expresscar.service;

import edu.zut.cs.software.base.service.GenericGenerator;
import edu.zut.cs.software.osals.expresscar.domain.Enwrap;
import edu.zut.cs.software.osals.expresscar.domain.ExpressCar;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: hyh
 * @Description: ExpressCar Entity Generator
 * @Date:Created in 23:02 2019/5/16
 * @Modified By:
 */
public class ExpressCarEntityGenerator extends GenericGenerator {

    @Autowired
    EnwrapManager enwrapManager;

    @Autowired
    ExpressCarManager expressCarManager;

    @Test
    public void gen_ExpressCar() {
        for(int i = 0; i < 2; i++) {
            ExpressCar e = new ExpressCar();
            e.setName("expressCar_" + i);
            this.expressCarManager.save(e);
            for(int j = 0; j < 2; j++) {
                ExpressCar expressCar = new ExpressCar();
                expressCar.setName("expressCar_" + i + "_" + j);
                expressCar.setParent(e);
                e = this.expressCarManager.save(expressCar);
                this.gen_enwrap(e);
            }
        }
    }

    public void gen_enwrap(ExpressCar e) {
        for(int i = 0; i < 2; i++) {
            Enwrap enwrap = new Enwrap();
            enwrap.setName("enwrap_" + i);
            enwrap.setTelephone(i+"11111");
            enwrap.setExpressCar(e);
            this.enwrapManager.save(enwrap);
        }
    }
}
