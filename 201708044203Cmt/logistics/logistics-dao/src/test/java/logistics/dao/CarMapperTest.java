package logistics.dao;

import logistics.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-dao.xml")
@Transactional
public class CarMapperTest {

    private CarMapper carMapper;

    @Autowired
    public void setCarMapper(CarMapper carMapper) {
        this.carMapper = carMapper;
    }

    @Test
    public  void getAllCarTest()
    {
        List<Car> list =carMapper.getAllCar();
        for (Car car: list) {
            System.out.println(car);
        }
    }}

