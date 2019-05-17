package edu.zut.cs.software.OSALS.courier.service;

import edu.zut.cs.software.OSALS.courier.domain.Courier;
import edu.zut.cs.software.OSALS.courier.domain.CourierCompany;
import edu.zut.cs.software.base.service.GenericGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CourierEntityGenerator extends GenericGenerator {

    @Autowired
    CourierManager courierManager;

    @Autowired
    CourierCompanyManager courierCompanyManager;

    @Test
    public void gen_courierCompany() {
        for(int i = 0; i < 10; i++) {
            CourierCompany c = new CourierCompany();
            c.setName("CourierCompany_" + i);
            this.courierCompanyManager.save(c);
            for(int j = 0; j < 10; j++) {
                CourierCompany courierCompany = new CourierCompany();
                courierCompany.setName("courierCompany_" + i + "_" + j);
                courierCompany.setParent(c);
                c = this.courierCompanyManager.save(courierCompany);
                this.gen_courier(c);
            }
        }
    }

    public void gen_courier(CourierCompany c) {
        for(int i = 0; i < 10; i++) {
            Courier cr = new Courier();
            cr.setName("courier_" + i);
            cr.setPhoneNumber("1883978528"+i);
            cr.setSex("女");
            cr.setCourierCompany(c);
            this.courierManager.save(cr);
        }
    }
}
