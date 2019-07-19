package edu.zut.cs.software.osals.car.web.spring.controller;


import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.car.domain.Driver;
import edu.zut.cs.software.osals.car.service.DriverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/driver")
public class DriverController extends GenericController<Driver,Long, DriverManager> {
    DriverManager driverManager;

    @Autowired
    public void setDriverManager(DriverManager driverManager) {
        this.driverManager = driverManager;
        this.manager=this.driverManager;
    }
    @GetMapping(value = "/all",  produces = "application/json;charset=utf-8")
    public @ResponseBody List<Driver> getAll(){
        List<Driver> all = this.manager.findAll();
        return all;
    }

    /**
     * 这里是删除，依据了在数据库中的id的值来查找 这个已经ok了
     * @param id
     * @return driver
     */
    @DeleteMapping(path = "/delete/{id}",produces = "application/json;charset=utf-8")
    public  @ResponseBody Driver deleteOne(@PathVariable(value = "id") Long id) {
        Driver driver = this.manager.findById(id);
        this.manager.delete(id);
        return driver;
    }
}
