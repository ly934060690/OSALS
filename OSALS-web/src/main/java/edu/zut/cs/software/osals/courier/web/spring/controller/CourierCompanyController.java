package edu.zut.cs.software.osals.courier.web.spring.controller;



import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.courier.domain.CourierCompany;
import edu.zut.cs.software.osals.courier.service.CourierCompanyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courierCompany")
public class CourierCompanyController extends GenericController<CourierCompany,Long, CourierCompanyManager> {


    CourierCompanyManager courierCompanyManager;
    @Autowired
    public  void setCourierCompanyManager(CourierCompanyManager courierCompanyManager)
    {
        this.courierCompanyManager=courierCompanyManager;
        this.manager=courierCompanyManager;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody List<CourierCompany> getAll(){
        List<CourierCompany> all = this.manager.findAll();
        return all;
    }

    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody CourierCompany saveOne( CourierCompany courierCompany){
        this.manager.save(courierCompany);
        return courierCompany;
    }

    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody CourierCompany  deleteOne(@PathVariable(value = "id") Long id) {
        CourierCompany courierCompany = this.manager.findById(id);
        this.manager.delete(id);
        return courierCompany;
    }



}