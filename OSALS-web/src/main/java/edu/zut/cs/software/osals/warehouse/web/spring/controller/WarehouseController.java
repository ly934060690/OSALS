package edu.zut.cs.software.osals.warehouse.web.spring.controller;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.nlp.domain.NlpKeywordExtraction;
import edu.zut.cs.software.osals.warehouse.daomain.Warehouse;
import edu.zut.cs.software.osals.warehouse.service.WarehouseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/6/25
 * @Description: edu.zut.cs.software.osals.warehouse.web.spring.controller
 * @version: 1.0
 */
@Controller
@RequestMapping(value = "/warehouse")
public class WarehouseController extends GenericController<Warehouse, Long, WarehouseManager> {

    WarehouseManager warehouseManager;
    Warehouse warehouse = new Warehouse();

    @Autowired
    public void setGoodsManager(WarehouseManager warehouseManager)
    {
        this.warehouseManager = warehouseManager;
        this.manager = this.warehouseManager;
    }


    /**
     * 这里是打开关键词提取的页面后就直接执行了getall方法
     * @return List<Warehouse>
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody List<Warehouse> getAll(){
        List<Warehouse> all = this.manager.findAll();
        return all;
    }

    /**
     * 这里是删除，依据了在数据库中的id的值来查找 这个已经ok了
     * @param id
     * @return nlpKeywordExtraction
     */
    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody Warehouse deleteOne(@PathVariable(value = "id") Long id) {
        Warehouse warehouse = this.warehouseManager.findById(id);
        this.manager.delete(id);
        return warehouse;
    }

    /**
     * 这里对应前端的部分是新增
     * @param warehouse
     * @return warehouse
     */
    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Warehouse saveOne( Warehouse warehouse){
        this.manager.save(warehouse);
        return warehouse;
    }

}
