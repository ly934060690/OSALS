package edu.zut.cs.software.osals.courier.web.spring.controller;



import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.courier.domain.CourierCompany;
import edu.zut.cs.software.osals.courier.service.CourierCompanyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @ResponseBody
    @GetMapping(value = "getAll",produces = "application/json;charset=utf-8")
    public List<CourierCompany> getAll(){
        return this.manager.findAll();
    }

//    @ResponseBody
//    @GetMapping(value = "allToString",produces = "application/json;charset=utf-8")
//    public String findAllCourierCompanyToString()
//    {
//        List<CourierCompany> courierCompanyList=this.manager.findAll();
//        PageInfo pageInfo=new PageInfo(courierCompanyList);
//        return JSON.toJSONString(pageInfo);
//    }

//    @ResponseBody
//    @GetMapping(value = "id/{id}",produces = "application/json;charset=utf-8")
//    public CourierCompany getCourierCompany(@PathVariable("id")Long id)
//    {
//        CourierCompany result=this.courierCompanyManager.findById(id);
//        System.out.println(result);
//        return result;
//    }


}