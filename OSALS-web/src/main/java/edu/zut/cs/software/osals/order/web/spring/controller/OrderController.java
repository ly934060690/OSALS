package edu.zut.cs.software.osals.order.web.spring.controller;


import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.order.domain.Order;
import edu.zut.cs.software.osals.order.service.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


//控制器Controller 负责处理由DispatcherServlet 分发的请求，
// 它把用户请求的数据经过业务处理层处理之后封装成一个Model ，
// 然后再把该Model 返回给对应的View 进行展示
    @Controller
    @RequestMapping("/order")
    public class OrderController extends GenericController<Order, Long, OrderManager> {

        OrderManager orderManager;
        @Autowired
        public void setShopManager(OrderManager orderManager) {
            this.orderManager = orderManager;
        }

        @RequestMapping("/index")
        public String index() {
            return "order/index";
        }

        @ResponseBody
        @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
        public String hello() {
            return "Hello, This is Order!";
        }

    @RequestMapping(value = "/page" ,method = RequestMethod.GET)
    public String page1()
    {
        System.out.println("跳轉頁面");
        return "/html/order";
    }

    @ResponseBody//标识转换成JSON处理
    @GetMapping(value = "createOrder",produces = "application/json;charset=utf-8")
    public List<Order> creatorder(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String nowTime = df.format(new Date());
        String payment_method="支付宝";
        float order_num=123456;
        return this.manager.createOrder(nowTime,payment_method,order_num);
    }
    @ResponseBody//标识转换成JSON处理
    @GetMapping(value = "allOrder",produces = "application/json;charset=utf-8")
    public List<Order> findAllOrder(){
        return this.manager.findAll();
    }

    @RequestMapping(value = "/pages" ,method = RequestMethod.GET)
    public String page2()
    {
        System.out.println("跳轉頁面");
        return "index";
    }

    }

