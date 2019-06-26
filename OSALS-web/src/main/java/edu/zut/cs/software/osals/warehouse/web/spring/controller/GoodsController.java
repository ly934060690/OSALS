package edu.zut.cs.software.osals.warehouse.web.spring.controller;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.nlp.domain.NlpKeywordExtraction;
import edu.zut.cs.software.osals.warehouse.daomain.Goods;
import edu.zut.cs.software.osals.warehouse.service.GoodsManager;
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
@RequestMapping(value = "/goods")
public class GoodsController extends GenericController<Goods, Long, GoodsManager> {
    GoodsManager goodsManager;
    Goods goods = new Goods();

    @Autowired
    public void setGoodsManager(GoodsManager goodsManager)
    {
        this.goodsManager = goodsManager;
        this.manager = this.goodsManager;
    }

    /**
     * 这里是打开关键词提取的页面后就直接执行了getall方法
     * @return List<Goods>
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody List<Goods> getAll(){
        List<Goods> all = this.manager.findAll();
        return all;
    }

    /**
     * 这里是删除，依据了在数据库中的id的值来查找 这个已经ok了
     * @param id
     * @return goods
     */
    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody Goods  deleteOne(@PathVariable(value = "id") Long id) {
        Goods goods = this.manager.findById(id);
        this.manager.delete(id);
        return goods;
    }

    /**
     * 这里对应前端的部分是新增
     * @param goods
     * @return goods
     */
    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Goods saveOne( Goods goods){
        this.manager.save(goods);
        return goods;
    }


}
