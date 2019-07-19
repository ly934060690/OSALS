package edu.zut.cs.software.osals.courier.web.spring.controller;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.courier.domain.Courier;
import edu.zut.cs.software.osals.courier.service.CourierManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courier")
public class CourierController extends GenericController<Courier,Long, CourierManager> {

    CourierManager courierManager;
    Courier courier=new Courier();

    @Autowired
    public void setCourierManager(CourierManager courierManager) {
        this.courierManager = courierManager;
        this.manager=this.courierManager;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody List<Courier> getAll(){
        List<Courier> all = this.manager.findAll();
        return all;
    }

    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Courier saveOne( Courier courier){
        this.manager.save(courier);
        return courier;
    }

    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody Courier  deleteOne(@PathVariable(value = "id") Long id) {
        Courier courier = this.manager.findById(id);
        this.manager.delete(id);
        return courier;
    }
}

