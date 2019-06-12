package edu.zut.cs.software.osals.car.web.spring.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.car.domain.Car;
import edu.zut.cs.software.osals.car.service.CarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController extends GenericController<Car,Long, CarManager> {
    CarManager carManager;

    @Autowired
    public void setCarManager(CarManager carManager) {
        this.carManager = carManager;
        this.manager=this.carManager;
    }

    @ResponseBody
    @GetMapping(value = "getAll",produces = "application/json;charset=utf-8")
    public String findAllCar() {

        //return this.manager.findAll();

        List<Car> shopList = this.manager.findAll();
        PageInfo pageInfo = new PageInfo(shopList);
        return JSON.toJSONString(pageInfo);
    }
}
