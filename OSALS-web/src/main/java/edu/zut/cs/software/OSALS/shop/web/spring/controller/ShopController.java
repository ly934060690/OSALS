package edu.zut.cs.software.OSALS.shop.web.spring.controller;

import edu.zut.cs.software.OSALS.shop.domain.Shop;
import edu.zut.cs.software.OSALS.shop.service.ShopManager;
import edu.zut.cs.software.base.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ShopController
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/5/21 22:49
 * @Version 1.0
 */
@Controller
@RequestMapping("/shop")
public class ShopController extends GenericController<Shop, Long, ShopManager> {

    ShopManager shopManager;
    @Autowired
    public void setShopManager(ShopManager shopManager) {
        this.shopManager = shopManager;
    }

    @RequestMapping("/index")
    public String index() {
        return "shop/index";
    }

    @ResponseBody
    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
    public String hello() {
        return "Hello, This is Shop!";
    }
}
