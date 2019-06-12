package edu.zut.cs.software.osals.order.web.spring.controller;


import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.order.domain.OrderGoods;
import edu.zut.cs.software.osals.order.service.OrderGoodsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
