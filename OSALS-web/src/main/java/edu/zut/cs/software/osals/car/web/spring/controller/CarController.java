package edu.zut.cs.software.osals.car.web.spring.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.car.domain.Car;
import edu.zut.cs.software.osals.car.service.CarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody List<Car> getAll(){
        List<Car> all = this.manager.findAll();
        return all;
    }

    /**
     * 这里是删除，依据了在数据库中的id的值来查找 这个已经ok了
     * @param id
     * @return car
     */
    @DeleteMapping(path = "/delete/{id}",  produces = "application/json;charset=utf-8")
    public  @ResponseBody Car deleteOne(@PathVariable(value = "id") Long id) {
        Car car = this.manager.findById(id);
        this.manager.delete(id);
        return car;
    }

    /**
     * 这里对应前端的部分是新增
     * @param car
     * @return car
     */
    @PostMapping(path = "/save",produces = "application/json;charset=utf-8")
    public @ResponseBody Car saveOne( Car car){
        this.manager.save(car);
        return car;
    }

}
