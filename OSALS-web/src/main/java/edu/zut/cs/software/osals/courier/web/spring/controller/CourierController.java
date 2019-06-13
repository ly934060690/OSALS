package edu.zut.cs.software.osals.courier.web.spring.controller;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.courier.domain.Courier;
import edu.zut.cs.software.osals.courier.service.CourierManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/courier")
public class CourierController extends GenericController<Courier,Long, CourierManager> {

    CourierManager courierManager;
    @Autowired
    public void setCourierManager(CourierManager courierManager)
    {
        this.courierManager=courierManager;
        this.manager=this.courierManager;
    }

    @ResponseBody
    @GetMapping(value = "all", produces = "application/json;charset=utf-8")
    public List<Courier> findAllCourier() {
        return this.manager.findAll();

    }


    //    @ResponseBody
//    @GetMapping(value = "id/{id}",produces = "application/json;charset=utf-8")
//    public Courier getCourierCompany(@PathVariable("id")Long id)
//    {
//        Courier result=this.courierManager.findById(id);
//        System.out.println(result);
//        return result;
//    }
    @ResponseBody
    @GetMapping(value = "name/{name}",produces = "application/json;charset=utf-8")
    public List<Courier> getCourier(@PathVariable String name) {
        return this.courierManager.findbyCouriername(name);
    }
}

