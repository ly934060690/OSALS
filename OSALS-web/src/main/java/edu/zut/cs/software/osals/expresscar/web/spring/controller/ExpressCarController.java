package edu.zut.cs.software.osals.expresscar.web.spring.controller;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.expresscar.domain.ExpressCar;
import edu.zut.cs.software.osals.expresscar.service.ExpressCarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: hyh
 * @Description: ExpressCar Controller
 * @Date:Created in 20:32 2019/6/3
 * @Modified By:
 */
@Controller
@RequestMapping("/expressCar")
public class ExpressCarController extends GenericController<ExpressCar,Long, ExpressCarManager> {

    ExpressCarManager expressCarManager;

    @Autowired
    public void setExpressCarManager(ExpressCarManager expressCarManager){
        this.expressCarManager=expressCarManager;
        this.manager=this.expressCarManager;
    }

    /**
     *@Description: 查找
     *@Date: 16:59 2019/6/24
     */
    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public List<ExpressCar> getAllExpressCar(){
        List<ExpressCar> list = this.manager.findAll();
        return list;
    }

    /**
     *@Description: 删除
     *@Date: 16:59 2019/6/24
     */
    @ResponseBody
    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public ExpressCar deleteExpressCar(@PathVariable(value = "id") Long id) {
        ExpressCar expressCar = this.manager.findById(id);
        this.manager.delete(id);
        return expressCar;
    }

    /**
     *@Description: 增加
     *@Date: 17:00 2019/6/24
     */
    @ResponseBody
    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public ExpressCar saveExpressCar( ExpressCar expressCar){
        this.manager.save(expressCar);
        return expressCar;
    }

}
