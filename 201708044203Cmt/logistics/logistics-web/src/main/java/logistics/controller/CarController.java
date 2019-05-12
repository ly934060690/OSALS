package logistics.controller;

import logistics.entity.Car;
import logistics.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    @GetMapping(value="getAllCar" , produces="application/json;charset=UTF-8")
    public List<Car> getAllCar(){
        return carService.getAllCar();
    }
}
