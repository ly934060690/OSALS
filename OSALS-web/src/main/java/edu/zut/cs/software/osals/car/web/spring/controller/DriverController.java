package edu.zut.cs.software.osals.car.web.spring.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.car.domain.Driver;
import edu.zut.cs.software.osals.car.service.DriverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    @GetMapping(value = "all", produces = "application/json;charset=utf-8")
    public String getAllDriver(){
        List<Driver> driverList = this.manager.findAll();
        PageInfo pageInfo = new PageInfo(driverList);
        return JSON.toJSONString(pageInfo);
    }
}
