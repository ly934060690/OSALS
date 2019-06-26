package edu.zut.cs.software.osals.expresscar.web.spring.controller;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.expresscar.domain.Enwrap;
import edu.zut.cs.software.osals.expresscar.service.EnwrapManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: hyh
 * @Description: Enwrap Controller
 * @Date:Created in 20:33 2019/6/3
 * @Modified By:
 */
@Controller
@RequestMapping("/enwrap")
public class EnwrapController extends GenericController<Enwrap,Long, EnwrapManager> {

    EnwrapManager enwrapManager;

    @Autowired
    public void setEnwrapManager(EnwrapManager enwrapManager){
        this.enwrapManager=enwrapManager;
        this.manager=this.enwrapManager;
    }

    /**
     *@Description: 查找
     *@Date: 16:59 2019/6/24
     */
    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public List<Enwrap> getAllEnwrap(){
        List<Enwrap> list = this.manager.findAll();
        return list;
    }

    /**
     *@Description: 删除
     *@Date: 16:59 2019/6/24
     */
    @ResponseBody
    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public Enwrap deleteEnwrap(@PathVariable(value = "id") Long id) {
        Enwrap enwrap = this.manager.findById(id);
        this.manager.delete(id);
        return enwrap;
    }

    /**
     *@Description: 增加
     *@Date: 17:00 2019/6/24
     */
    @ResponseBody
    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Enwrap saveEnwrap( Enwrap enwrap){
        this.manager.save(enwrap);
        return enwrap;
    }

}
