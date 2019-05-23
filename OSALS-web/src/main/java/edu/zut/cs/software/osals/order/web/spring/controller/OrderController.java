package edu.zut.cs.software.osals.order.web.spring.controller;


import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.order.domain.Order;
import edu.zut.cs.software.osals.order.service.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
    }

