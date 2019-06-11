package edu.zut.cs.software.osals.hanlp.web.spring.controller;

import com.alibaba.fastjson.JSON;
import com.hankcs.hanlp.seg.common.Term;
import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.hanlp.domain.Hanlp;
import edu.zut.cs.software.osals.hanlp.service.HanlpManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName HanlpController
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/6/11 17:40
 * @Version 1.0
 */
@Controller
@RequestMapping("/hanlp")
public class HanlpController extends GenericController<Hanlp, Long, HanlpManager> {

    HanlpManager hanlpManager;

    @Autowired
    public void setHanlpManager(HanlpManager hanlpManager) {
        this.hanlpManager = hanlpManager;
        this.manager = this.hanlpManager;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public String index() {
        String result = "index";
        return result;
    }

    @ResponseBody
    @GetMapping(value = "text/{text}", produces = "application/json;charset=utf-8")
    public String getNormWord(@PathVariable("text") String text) {
        List<Term> result = this.manager.normWord(text);
        Hanlp hanlp = new Hanlp();
        hanlp.setText(text);
        hanlp.setWord(result.toString());
        this.manager.save(hanlp);
        return JSON.toJSONString(result);
    }
}
