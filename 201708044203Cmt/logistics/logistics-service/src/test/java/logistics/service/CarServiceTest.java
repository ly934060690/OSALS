package logistics.service;


import logistics.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration(locations = {"classpath:spring/applicationContext-service.xml",
        "classpath*:spring/applicationContext-dao.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CarServiceTest {

    private  CarService carService;

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @Test
    public void getAllCarTest(){
        List<Car> list =carService.getAllCar();
        for (Car car : list) {
            System.out.println(car);
        }

    }
}
