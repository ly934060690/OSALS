package logistics.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import logistics.entity.Car;
import logistics.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("car")
public class CarController {
    private CarService carService;

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    //得到所有
    @ResponseBody
    @GetMapping(value="getAllCar" , produces="application/json;charset=utf-8")
    public List<Car> getAllCar(){
        return carService.getAllCar();
    }

    @GetMapping(value = "getInfo", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllCarByPage(@RequestParam("pageNum") Integer pageNum,
                                  @RequestParam("pageSize") Integer pageSize,
                                  @RequestParam("navigatePages") Integer navigatePages) {
        PageHelper.startPage(pageNum,pageSize);
        List<Car> carList = carService.getAllCar();
        PageInfo info = new PageInfo(carList,navigatePages);
        return JSON.toJSONString(info);
    }

    @ResponseBody
    @GetMapping(value = "getOneCar",produces = "application/json;charset=utf-8")
    public Car getOneCarById(@RequestBody String msg)
    {
        Map map= (Map)JSONObject.parse(msg);
        Integer id =Integer.valueOf((String)map.get("id"));
        return carService.getCarById(id);

    }
    @ResponseBody
    @PostMapping(value = "saveOne",produces = "application/json;charset=utf-8")
    public Integer saveOne(@RequestBody String msg){
        Car car= JSONObject.parseObject(msg,Car.class);
        return carService.saveOne(car);
    }

    @ResponseBody
    @PostMapping(value="updateOne",produces = "application/json;charset=utf-8")
    public  Integer updateById(@RequestBody String msg){
        Car car= JSONObject.parseObject(msg,Car.class);
        return  carService.updateById(car);
    }

    @ResponseBody
    @DeleteMapping(value="deleteOne",produces = "application/json;charset=utf-8")
    public Integer deleteById(@RequestBody String msg){
        Map map= (Map) JSONObject.parse(msg);
       Integer id= Integer.valueOf((String)map.get("id"));
        return carService.deleteById(id);
    }
}
