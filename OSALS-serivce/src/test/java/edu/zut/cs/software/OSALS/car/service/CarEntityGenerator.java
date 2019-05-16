package edu.zut.cs.software.OSALS.car.service;


import edu.zut.cs.software.OSALS.Driver.domain.Driver;
import edu.zut.cs.software.OSALS.car.domain.Car;
import edu.zut.cs.software.OSALS.driver.service.DriverManager;
import edu.zut.cs.software.base.service.GenericGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class CarEntityGenerator  extends GenericGenerator {
    @Autowired
    CarManager carManager;

    @Autowired
    DriverManager driverManager;

    @Test
    public void gen_Car() {
        for(int i = 0; i < 10; i++) {
            Car s = new Car();
            s.setCarNum("car_" + i);
            this.carManager.save(s);
            for(int j = 0; j < 10; j++) {
                Car car = new Car();
                car.setCarNum("car_" + i + "_" + j);
                car.setCarLoad(s.getCarLoad());
                s = this.carManager.save(car);
                this.gen_driver(s);
            }
        }
    }

    @Test
    public void gen_driver(Car s) {
        for(int i = 0; i < 10; i++) {
            Driver c = new Driver();
            c.setDriNum("driver_" + i);
            c.setDriName("car_" + i );
            c.setDriCode("car_" +i );
            c.setDriSex("car_" + i );
            c.setDriTel("car_" + i );
            c.setCar(s);
            this.driverManager.save(c);
        }
    }
}
