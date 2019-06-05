package zut.cs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: LBW
 * @Date: 2019/5/30
 * @Description: zut.cs
 * @version: 1.0
 */
@Controller
@RequestMapping("/Anno")
public class AnnoController {

    @RequestMapping("/TestAnno")
    public String TestAnno(@RequestParam(name = "lbw") String lbw)
    {
         System.out.println(lbw);
        return "success";
    }

    @RequestMapping("/TestRequestBody")  //这里获取请求体，这里不能写和表单一样的参数，否则会出错！！
    public String TestRequestBody(@RequestBody String body)
    {
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/TestPathVariable/{userid}")
    public String TestPathVariable(@PathVariable(name ="userid") String id)
    {
        System.out.println(id);
        return "success";
    }


}
