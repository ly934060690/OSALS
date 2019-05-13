package logistics.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import logistics.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
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

        PageHelper.startPage(2,10);
        List<Car> list =carService.getAllCar();
        PageInfo info = new PageInfo(list);

        System.out.println(JSON.toJSONString(info));
//        for (Car car : list) {
//            System.out.println(car);
//        }
    }

    @Test
    public  void getCarByIdTest()
    {
        Car car=carService.getCarById(5);
        System.out.println(car);
    }

}
