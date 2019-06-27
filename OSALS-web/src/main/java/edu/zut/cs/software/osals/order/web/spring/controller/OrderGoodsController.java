package edu.zut.cs.software.osals.order.web.spring.controller;


import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.order.domain.OrderGoods;
import edu.zut.cs.software.osals.order.service.OrderGoodsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ordergoods")
public class OrderGoodsController extends GenericController<OrderGoods, Long, OrderGoodsManager> {

    OrderGoodsManager orderGoodsManager;
    @Autowired
    public void setCommodityManager(OrderGoodsManager orderGoodsManager) {
        this.orderGoodsManager = orderGoodsManager;
        this.manager = this.orderGoodsManager;
    }

    @RequestMapping("/index")
    public String index() {
        return "ordergoods/index";
    }

    @ResponseBody
    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
    public String hello() {
        return "Hello, This is OrderGoods!";
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody
    List<OrderGoods> getAll(){
        List<OrderGoods> all = this.manager.findAll();
        return all;
    }

    /**
     * 这里是删除，依据了在数据库中的id的值来查找 这个已经ok了
     * @param id
     * @return goods
     */
    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody OrderGoods  deleteOne(@PathVariable(value = "id") Long id) {
        OrderGoods orderGoods = this.manager.findById(id);
        this.manager.delete(id);
        return orderGoods;
    }

    /**
     * 这里对应前端的部分是新增
     * @param orderGoods
     * @return ordergoods
     */
    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody OrderGoods saveOne( OrderGoods orderGoods){
        this.manager.save(orderGoods);
        return orderGoods;
    }
}
